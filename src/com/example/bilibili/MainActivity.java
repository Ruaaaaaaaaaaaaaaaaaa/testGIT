package com.example.bilibili;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	private static int current_imagebutton;
	private ImageButton ib_home;
	private ImageButton ib_list;
	private ImageButton ib_favor;
	private ImageButton ib_search;
	private ImageButton ib_my;
	private TextView tv_home;
	private TextView tv_list;
	private TextView tv_favor;
	private TextView tv_search;
	private TextView tv_my;
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);	
		if(VERSION.SDK_INT>=VERSION_CODES.LOLLIPOP)
		{
			Window window =getWindow();
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS|
							  WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
														|View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
														|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.setStatusBarColor(Color.TRANSPARENT);
			window.setNavigationBarColor(Color.TRANSPARENT);
		}
		
		setContentView(R.layout.activity_main);
		init();
	}
	private void init() {
		// TODO Auto-generated method stub
		ib_home= (ImageButton) findViewById(R.id.ib_home);
		ib_favor=(ImageButton) findViewById(R.id.ib_favor);
		ib_list=(ImageButton) findViewById(R.id.ib_list);
		ib_search=(ImageButton) findViewById(R.id.ib_search);
		ib_my=(ImageButton) findViewById(R.id.ib_my);
		tv_home = (TextView) findViewById(R.id.tv_home);
		tv_favor = (TextView) findViewById(R.id.tv_favor);
		tv_list = (TextView) findViewById(R.id.tv_list);
		tv_search = (TextView) findViewById(R.id.tv_search);
		tv_my = (TextView) findViewById(R.id.tv_my);
		
		Fragment1 fragment1 = new Fragment1();
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.add(R.id.framelayout, fragment1);
		//transaction.addToBackStack(null);
		transaction.commit();
		ib_home.setImageResource(R.drawable.home_fill);
		tv_home.setTextColor(Color.parseColor("#fa7296"));
		current_imagebutton = R.id.ib_home;
		
		
		
		ib_home.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(current_imagebutton != R.id.ib_home)
				{
					//图标变色 目
					ChangeColor();
					ib_home.setImageResource(R.drawable.home_fill);
					tv_home.setTextColor(Color.parseColor("#fa7296"));
					
					//改变fragment
					Fragment1 fragment1 = new Fragment1();
					FragmentManager fragmentManager = getSupportFragmentManager();
					FragmentTransaction transaction = fragmentManager.beginTransaction();
					transaction.replace(R.id.framelayout, fragment1);
					//transaction.addToBackStack(null);
					transaction.commit();
					current_imagebutton = R.id.ib_home;
				}
			}
		});
		ib_list.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(current_imagebutton != R.id.ib_list)
				{
					//图标变色 目前未实现
					ChangeColor();
					ib_list.setImageResource(R.drawable.list_fill);
					tv_list.setTextColor(Color.parseColor("#fa7296"));
					//改变fragment
					Fragment2 fragment2 = new Fragment2();
					FragmentManager fragmentManager = getSupportFragmentManager();
					FragmentTransaction transaction = fragmentManager.beginTransaction();
					transaction.replace(R.id.framelayout, fragment2);
					//transaction.addToBackStack(null);
					transaction.commit();
					current_imagebutton = R.id.ib_list;
				}
			}
		});
		ib_favor.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(current_imagebutton != R.id.ib_favor)
			{
				//图标变色 目前未实现
				ChangeColor();
				
				ib_favor.setImageResource(R.drawable.favor_fill);
				
				tv_favor.setTextColor(Color.parseColor("#fa7296"));
				//改变fragment
				Fragment3 fragment3 = new Fragment3();
				FragmentManager fragmentManager = getSupportFragmentManager();
				FragmentTransaction transaction = fragmentManager.beginTransaction();
				transaction.replace(R.id.framelayout, fragment3);
				//transaction.addToBackStack(null);
				transaction.commit();
				current_imagebutton = R.id.ib_favor;
			}
		}

		
		});
		ib_search.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(current_imagebutton != R.id.ib_search)
			{
				//图标变色 目前未实现
				ChangeColor();
				ib_search.setImageResource(R.drawable.search_fill);
				tv_search.setTextColor(Color.parseColor("#fa7296"));
				//改变fragment
				Fragment4 fragment4 = new Fragment4();
				FragmentManager fragmentManager = getSupportFragmentManager();
				FragmentTransaction transaction = fragmentManager.beginTransaction();
				transaction.replace(R.id.framelayout, fragment4);
				//transaction.addToBackStack(null);
				transaction.commit();
				current_imagebutton = R.id.ib_search;
			}
		}
		});
		ib_my.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(current_imagebutton != R.id.ib_my)
				{
					//图标变色 目前未实现
					ChangeColor();
					ib_my.setImageResource(R.drawable.my_fill);
					tv_my.setTextColor(Color.parseColor("#fa7296"));
					//改变fragment
					Fragment4 fragment4 = new Fragment4();
					FragmentManager fragmentManager = getSupportFragmentManager();;
					FragmentTransaction transaction = fragmentManager.beginTransaction();
					transaction.replace(R.id.framelayout, fragment4);
					//transaction.addToBackStack(null);
					transaction.commit();
					current_imagebutton = R.id.ib_my;
				}
			}
		});
	}
	protected void ChangeColor() {
		// TODO Auto-generated method stub
		ib_home.setImageResource(R.drawable.home);
		ib_favor.setImageResource(R.drawable.favor);
		ib_search.setImageResource(R.drawable.search);
		ib_my.setImageResource(R.drawable.my);
		ib_list.setImageResource(R.drawable.list);
		tv_home.setTextColor(Color.parseColor("#000000"));
		tv_favor.setTextColor(Color.parseColor("#000000"));
		tv_search.setTextColor(Color.parseColor("#000000"));
		tv_my.setTextColor(Color.parseColor("#000000"));
		tv_list.setTextColor(Color.parseColor("#000000"));
	}
}
