package com.example.utils;

import com.example.bilibili.R;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class BitmapUtils {
	private NetCacheUtils mNetCacheUtils;
	private LocalCacheUtils mLocalCacheUtils;
	private MemoryCacheUtils mMemoryCacheUtils;
	
	public BitmapUtils(){
		mMemoryCacheUtils = new MemoryCacheUtils();
		mLocalCacheUtils = new LocalCacheUtils();
		mNetCacheUtils = new NetCacheUtils(mLocalCacheUtils,mMemoryCacheUtils);
	}
	
	public void disPlay(ImageView img,String url){
		/*if(img==null){
			img.setImageResource(R.drawable.ic_launcher);
		}*/
		Bitmap bitmap;
		bitmap = mMemoryCacheUtils.getBitmapFromMemory(url);
		if(bitmap!=null){
			img.setImageBitmap(bitmap);
			return;
		}
		
		bitmap = mLocalCacheUtils.getBitmapFromLocal(url);
		if(bitmap!=null){
			img.setImageBitmap(bitmap);
			mMemoryCacheUtils.setBitmapToMemory(url, bitmap);
			return ;
		}
		
		mNetCacheUtils.getBitmapFromNet(img, url);
	
	}
}
