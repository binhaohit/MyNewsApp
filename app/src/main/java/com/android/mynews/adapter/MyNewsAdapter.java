package com.android.mynews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.mynews.R;
import com.android.mynews.beans.ZhihuBean;
import com.android.mynews.beans.ZhihuDailyItem;
import com.android.mynews.utils.MyUtils;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/24.
 */

public class MyNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    ZhihuBean mZhihuBean;
    List<ZhihuDailyItem> mZhihuItemsList = new ArrayList<ZhihuDailyItem>();
    boolean loading;

    public MyNewsAdapter(Context context) {
        mContext = context;
        Log.d(MyUtils.TAG, "MyNewsAdapter(context) "+this);
    }
    public MyNewsAdapter(Context context, ZhihuBean zhihuBean){
        mContext = context;
        mZhihuBean = zhihuBean;
    }

    public void updateAdapter(ZhihuBean zhihuBean) {
        if (zhihuBean==null) {
            return;
        }
        mZhihuBean = zhihuBean;
        mZhihuItemsList.addAll(zhihuBean.getStories());
        Log.d(MyUtils.TAG, "updateAdapter "+this+", listcount="+mZhihuItemsList.size());
        notifyDataSetChanged();
    }

    public void loadingStart() {
        if (loading) return;
        loading = true;
        int position = getLoadingPosition();
        Log.d(MyUtils.TAG, "loadingStart() position="+position);
//        notifyItemInserted(getLoadingPosition());
    }

    public void loadingFinish() {
        if (!loading) return;
        Log.d(MyUtils.TAG, "loadingFinish()");
        int position = getLoadingPosition();
        loading = false;
//        notifyItemRemoved(position);
    }

    private int getLoadingPosition() {
        Log.d(MyUtils.TAG, "getLoadingPosition() count="+getItemCount()+", loading? "+loading);
        return loading?(getItemCount()-2):RecyclerView.NO_POSITION;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Log.d(MyUtils.TAG, "onCreateViewHolder");
        return new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.mynews_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d(MyUtils.TAG, "onBindViewHolder position:"+position);
        MyHolder myHolder = (MyHolder) holder;

        if (mZhihuItemsList.size() > 0) {
            ZhihuDailyItem item = mZhihuItemsList.get(position);
            myHolder.news_title.setText(item.getTitle());
            myHolder.news_summary.setVisibility(View.GONE);
            if (item.getImages()!=null) {
                Glide.with(mContext)
                        .load(item.getImages().get(0))
                        .asBitmap()
                        .error(R.mipmap.ic_launcher)
                        .into(myHolder.news_image);
            }
            Log.d(MyUtils.TAG, "onBindViewHolder init finish----");
        } else {
            myHolder.news_image.setImageResource(R.mipmap.ic_launcher);
            myHolder.news_title.setText(R.string.app_name);
            myHolder.news_summary.setText(R.string.menu_setting);
        }
    }

    @Override
    public int getItemCount() {
//        Log.d(MyUtils.TAG, "getItemCount");
//        return mZhihuBean!=null?(mZhihuBean.getStories()!=null ? mZhihuBean.getStories().size():30):30;
        return mZhihuItemsList==null ? 0 : mZhihuItemsList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        ImageView news_image;
        TextView news_title;
        TextView news_summary;

        public MyHolder(View itemView) {
            super(itemView);
            news_image = (ImageView) itemView.findViewById(R.id.news_image);
            news_title = (TextView) itemView.findViewById(R.id.news_title);
            news_summary = (TextView) itemView.findViewById(R.id.news_summary);
        }
    }
}
