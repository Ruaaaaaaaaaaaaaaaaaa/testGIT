package com.example.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

public class MemoryCacheUtils {
	private LruCache<String , Bitmap> mMemoryCache;
	
	public MemoryCacheUtils(){
		long maxMemory = Runtime.getRuntime().maxMemory()/8;
		mMemoryCache = new LruCache<String,Bitmap>((int) maxMemory){
			@Override
			protected int sizeOf(String key, Bitmap value) {
				int byteCount = value.getByteCount();
				return byteCount;
			}
		};
	}
	
	public Bitmap getBitmapFromMemory(String url){
		Bitmap bitmap = mMemoryCache.get(url);
		return bitmap;
	}
	
	public void setBitmapToMemory(String url,Bitmap bitmap){
		mMemoryCache.put(url, bitmap);
	}
}
