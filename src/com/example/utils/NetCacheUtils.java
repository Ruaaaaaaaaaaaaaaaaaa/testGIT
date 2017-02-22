package com.example.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;



import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class NetCacheUtils {
	private LocalCacheUtils mLocalCacheUtils;
	private MemoryCacheUtils mMemoryCacheUtils;
	
	//private Set<BitmapTask>taskCollection = new HashSet<BitmapTask>();
	
	public NetCacheUtils(LocalCacheUtils localCacheUtils, MemoryCacheUtils memoryCacheUtils) {
		mLocalCacheUtils = localCacheUtils;
		mMemoryCacheUtils = memoryCacheUtils;
	}
	
	public void getBitmapFromNet(ImageView img,String url){
		new BitmapTask().execute(img,url);
	}
	
	class BitmapTask extends AsyncTask<Object,Void,Bitmap>{
		private ImageView img;
		private String url;
		@Override
		protected Bitmap doInBackground(Object... params) {
			img = (ImageView) params[0];
			url = (String)params[1];
			
			return downLoadBitmap(url);
		}
		@Override
		protected void onPostExecute(Bitmap result) {
			if(result !=null){
				img.setImageBitmap(result);
				
				mLocalCacheUtils.setBitmapToLocal(url, result);
				
				mMemoryCacheUtils.setBitmapToMemory(url, result);
				
				
			}
			//taskCollection.remove(this);
		}
	}
	private Bitmap downLoadBitmap(String url){
		HttpURLConnection conn = null;
		try{
			conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.setRequestMethod("GET");
			
			int responserCode = conn.getResponseCode();
			if(responserCode==200){
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inSampleSize=2;
				options.inPreferredConfig=Bitmap.Config.ARGB_4444;
				Bitmap bitmap = BitmapFactory.decodeStream(conn.getInputStream(),null,options);
				return bitmap;
			}
		}catch(IOException e ){
			e.printStackTrace();
		}finally {
			if(conn!=null)
				conn.disconnect();
		}
		return null;
	}


}
