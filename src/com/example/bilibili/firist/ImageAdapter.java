package com.example.bilibili.firist;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import com.example.bilibili.MainActivity;
import com.example.bilibili.R;
import com.example.utils.BitmapUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ImageAdapter extends ArrayAdapter<String> implements OnScrollListener{
	//private Set<BitmapWorkerTask> taskCollection;
	private int mFirstVisibleItem;
	private int mVisibleItemCount;
	private boolean isFirstEnter = true;
	private ListView mListView;
	private LruCache<String,BitmapDrawable> mMemoryCache;
	private BitmapUtils bitmapUtils = new BitmapUtils();
	
	public ImageAdapter(Context context, int resource, String[] objects,ListView listview) {  
		super(context, resource, objects);
		mListView = listview;
	
		
		mListView.setOnScrollListener(this);
	 } 

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
//		  if(mListView == null) {    
//			  mListView = (ListView) parent;    
//		  }   

		  final String url = getItem(position);
		  View view;
		  if(convertView==null){
			  view = LayoutInflater.from(getContext()).inflate(R.layout.imageitem, null);
		  }else{
			  view = convertView;
		  }
		  final ImageView image = (ImageView) view.findViewById(R.id.image);
		  
		  //image.setImageResource(R.drawable.ic_launcher); 
		  bitmapUtils.disPlay(image,url);
		  image.setTag(url);
		  return view;
	}
	


	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		if(scrollState==SCROLL_STATE_IDLE){
			loadBitmaps(mFirstVisibleItem,mVisibleItemCount);
		}else{
			cancelAllTask();
		}
		
	}

	private void cancelAllTask() {
		/*if(taskCollection!=null){
			for(BitmapWorkerTask task :taskCollection){
				task.cancel(false);
			}
		}
		*/
	}

	private void loadBitmaps(int firstVisibleItem, int visibleItemCount) {
		try{
			for(int i= firstVisibleItem;i<firstVisibleItem+visibleItemCount;i++){
				String imageUrl =Images.imageUrls[i];
				ImageView imageView = (ImageView) mListView.findViewWithTag(imageUrl);
				bitmapUtils.disPlay(imageView,imageUrl);
			
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
		
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		mFirstVisibleItem = firstVisibleItem;
		mVisibleItemCount = visibleItemCount;
		if(isFirstEnter&&visibleItemCount>0){
			loadBitmaps(firstVisibleItem, visibleItemCount);
			isFirstEnter = false;
		}
	}
}
