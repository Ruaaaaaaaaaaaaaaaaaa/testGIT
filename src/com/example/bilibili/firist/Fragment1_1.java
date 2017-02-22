package com.example.bilibili.firist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.bilibili.R;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

public class Fragment1_1 extends Fragment{
	private ListView mListView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.acitity1_1, container, false);
		
		init(view);
		ImageAdapter adapter  = new ImageAdapter(this.getContext(),0, Images.imageUrls,mListView);
		mListView.setAdapter(adapter);
		return view;
	}
	private void init(View view) {
		mListView = (ListView) view.findViewById(R.id.listview1_1);
	}
	
	
}
