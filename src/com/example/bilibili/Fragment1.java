package com.example.bilibili;

import java.util.ArrayList;
import java.util.List;

import com.example.bilibili.firist.Fragment1_1;
import com.example.bilibili.firist.Fragment1_2;
import com.example.bilibili.firist.Fragment1_3;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class Fragment1 extends Fragment{
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mDatas;
	private View mLine;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity1, container, false);
		
		initView(view);
		return view;
		
	}
	@SuppressWarnings("deprecation")
	private void initView(View view) {
		// TODO Auto-generated method stub
		mViewPager = (ViewPager) view.findViewById(R.id.mViewPager);
		mDatas = new ArrayList<Fragment>();
		mLine  = view.findViewById(R.id.mline);
		
		Fragment1_1 tab1 = new Fragment1_1();
		Fragment1_2 tab2 = new Fragment1_2();
		Fragment1_3 tab3 = new Fragment1_3();
		
		mDatas.add(tab1);
		mDatas.add(tab2);
		mDatas.add(tab3);
		
		mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
		
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mDatas.size();
			}
			
			@Override
			public android.support.v4.app.Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return mDatas.get(arg0);
			}
		};
		mViewPager.setAdapter(mAdapter);
		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPx) {
				// TODO Auto-generated method stub
				//Log.i("tag",position+","+positionOffset+","+positionOffsetPx);
				RelativeLayout.LayoutParams lp = (LayoutParams) mLine.getLayoutParams();
				lp.leftMargin = (int) ((position+positionOffset)*106-6);
				mLine.setLayoutParams(lp);
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}
