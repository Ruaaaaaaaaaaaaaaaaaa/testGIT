package com.example.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

public class LocalCacheUtils {
	private static final String CACHE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()+"/downimage";
	
	public Bitmap getBitmapFromLocal(String url){
		String fileName = null;
		try{
			 //fileName = MD5Encoder.encode(url);
			fileName = url;
			File file = new File(CACHE_PATH,fileName);
			Log.i("qqq", CACHE_PATH);
			Log.i("qqq", file.toString());
			Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
			
			return bitmap;
		}catch(Exception e ){
			e.printStackTrace();
		}
		return null;
	}
	
	public void setBitmapToLocal(String url,Bitmap bitmap){
		try{
			//String fileName = MD%Encoder.encode(url);
			String fileName = url;
			File file = new File(CACHE_PATH,fileName);
			
			File parentFile = file.getParentFile();
			if(!parentFile.exists()){
				parentFile.mkdirs();
			}
			bitmap.compress(Bitmap.CompressFormat.JPEG,100,new FileOutputStream(file));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
