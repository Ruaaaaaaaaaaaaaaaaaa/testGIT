package com.example.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class NormalLoadPictrue {
	private String uri;
	private ImageView imageView;
	private byte[] picByte;
	
	public void getPicture(String uri,ImageView imageView){
		this.uri = uri;
		this.imageView = imageView;
		new Thread(runnable).start();
	}
	
	Handler handle = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if(msg.what == 1){
				if(picByte != null){
					
				}
			}
		}
	};
	
	Runnable runnable = new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				URL url = new URL(uri);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setReadTimeout(100000);
				
				if(conn.getResponseCode()==200){
					
				}
			}catch(Exception e){
				
			}
		}
		
	};
}
