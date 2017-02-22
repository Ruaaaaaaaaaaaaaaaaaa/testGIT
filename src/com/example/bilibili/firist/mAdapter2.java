package com.example.bilibili.firist;

import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

import com.example.bilibili.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class mAdapter2 extends BaseAdapter {
	private Context mContext;
	private List<Map> mList;
	private MyView2 myview;
	public mAdapter2(Context context,List<Map> list) {
		// TODO Auto-generated constructor stub
		this.mContext =  context;
		mList = list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater lif = LayoutInflater.from(mContext);
		if(convertView==null)
		{
			myview = new MyView2();
			convertView=lif.inflate(R.layout.test1, null);
			convertView.setTag(myview);
		}else{
			myview = (MyView2) convertView.getTag();
		}
		//myview.mImageView = (ImageView) convertView.findViewById(R.id.image);
		myview.area = (TextView) convertView.findViewById(R.id.area);
		myview.more = (TextView) convertView.findViewById(R.id.more);
		myview.image1= (ImageView) convertView.findViewById(R.id.image1);
		myview.image1= (ImageView) convertView.findViewById(R.id.image2);
		//myview.gridview = (GridView) convertView.findViewById(R.id.gridview);
		//myview.mImageView.setImageDrawable((Drawable) mList.get(position).get("image"));
		myview.area.setText(mList.get(position).get("area").toString());
		myview.more.setText(mList.get(position).get("more").toString());
	
		
		
		
		return convertView;
	}

}
