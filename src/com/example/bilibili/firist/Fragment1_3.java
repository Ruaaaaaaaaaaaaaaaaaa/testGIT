package com.example.bilibili.firist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.bilibili.R;


import android.support.v4.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Fragment1_3 extends Fragment{
	private ListView mListView;
	private List<Map> mList;
	private GridView mgridview;
	private mAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.acitity1_3, container, false);
		init(view);
		adapter = new mAdapter(this.getContext(),getData());
		mListView.setAdapter(adapter);
		return view;
	}
	private List<Map> getData() {
		// TODO Auto-generated method stub
		Drawable[]b={getContext().getDrawable(R.drawable.q1),
				getContext().getDrawable(R.drawable.favor),
				getContext().getDrawable(R.drawable.favor_fill),
				getContext().getDrawable(R.drawable.home),
				getContext().getDrawable(R.drawable.home_fill),
				getContext().getDrawable(R.drawable.q1),
				getContext().getDrawable(R.drawable.favor),
				getContext().getDrawable(R.drawable.favor_fill),
				getContext().getDrawable(R.drawable.home),
				getContext().getDrawable(R.drawable.home_fill)};
		String []s={"q","w","e","q","w","e",
				"q","w","e","t"};
		for(int i=0;i<10;i++)
		{
			HashMap<String,Object> tmp=new HashMap<>();
			tmp.put("image", b[i]);
			tmp.put("text", s[i]);
			mList.add(tmp);
		}
		
		
		return mList;
	}
	private void init(View view) {
		// TODO Auto-generated method stub
		mListView = (ListView) view.findViewById(R.id.listview1_3);
		mList = new ArrayList<Map>();
	}
}
