package com.example.bilibili.firist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.bilibili.R;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Fragment1_2 extends Fragment{
	private ListView mListView;
	private List<Map> mList;
	private GridView mgridview;
	private mAdapter2 adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.acitity1_2, container, false);
			
		init(view);
		adapter = new mAdapter2(this.getContext(),getData());
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
		String []area ={"鬼畜区","舞蹈区","视频区","鬼畜区","舞蹈区","视频区","鬼畜区","舞蹈区","视频区","鬼畜区"};
		String []more ={"更多鬼畜","更多舞蹈","更多视频","更多鬼畜","更多舞蹈","更多视频","更多鬼畜","更多舞蹈","更多视频",
				"更多鬼畜"};
		for(int i=0;i<10;i++)
		{
			HashMap<String,Object> tmp=new HashMap<>();
			tmp.put("area", area[i]);
			tmp.put("more", more[i]);
			mList.add(tmp);
		}
		
		
		return mList;
	}
	private void init(View view) {
		// TODO Auto-generated method stub
		mListView = (ListView) view.findViewById(R.id.listview1_2);
		mList = new ArrayList<Map>();
	}
}
