package com.android.mynews;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.android.mynews.activitys.BaseActivity;
import com.android.mynews.adapter.MyViewPagerAdapter;
import com.android.mynews.beans.ZhihuBean;
import com.android.mynews.fragments.ToutiaoFragment;
import com.android.mynews.fragments.WangyiFragment;
import com.android.mynews.fragments.ZhihuFragment;
import com.android.mynews.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/24.
 */

public class MyNewsActivity extends BaseActivity {
    @BindView(R.id.mynews_toolbar)
    Toolbar mynewsToolbar;
    @BindView(R.id.myviewpager)
    ViewPager mViewPager;
    ZhihuBean mZhihuBean;
    FragmentManager fragmentManager;
    Fragment fragmentZhihu;
    Fragment fragmentWangyi;
    Fragment fragmentToutiao;
    FragmentPagerAdapter fragmentPagerAdapter;
    List<Fragment> mFragmentList = new ArrayList<Fragment>();
    @BindView(R.id.tab_zhihu)
    TextView tabZhihu;
    @BindView(R.id.tab_wangyi)
    TextView tabWangyi;
    @BindView(R.id.tab_toutiao)
    TextView tabToutiao;
    @BindView(R.id.mynews_navigationview)
    NavigationView mynewsNavigationview;
    Context mContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mynews);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ButterKnife.bind(this);
        setSupportActionBar(mynewsToolbar);
        init();
    }

    private void init() {
        mContext = this;
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        mViewPager.addOnPageChangeListener(new MyPagerListener());
        fragmentZhihu = new ZhihuFragment();
        fragmentWangyi = new WangyiFragment();
        fragmentToutiao = new ToutiaoFragment();
        mFragmentList.add(fragmentZhihu);
        mFragmentList.add(fragmentWangyi);
        mFragmentList.add(fragmentToutiao);
        fragmentPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(fragmentPagerAdapter);
        mViewPager.setCurrentItem(0);
        tabZhihu.setTextColor(mContext.getResources().getColor(R.color.colorRed));
        tabWangyi.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
        tabToutiao.setTextColor(mContext.getResources().getColor(R.color.colorBlack));

//        fragmentManager = getSupportFragmentManager();
//        fragmentZhihu = new ZhihuFragment(this);
//        fragmentWangyi = new WangyiFragment();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
////        transaction.hide(fragmentZhihu);
//        transaction.add(R.id.content, fragmentZhihu);
//        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mynews, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /*case R.id.menu_setting:
                Log.d(MyUtils.TAG, "onOptionsItemSelected-- menu_setting");
                break;*/
            case R.id.menu_about:
                break;
            case R.id.menu_help:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.tab_zhihu, R.id.tab_wangyi, R.id.tab_toutiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tab_zhihu:
                mViewPager.setCurrentItem(0);
                tabZhihu.setTextColor(mContext.getResources().getColor(R.color.colorRed));
                tabWangyi.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
                tabToutiao.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
                break;
            case R.id.tab_wangyi:
                mViewPager.setCurrentItem(1);
                tabZhihu.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
                tabWangyi.setTextColor(mContext.getResources().getColor(R.color.colorRed));
                tabToutiao.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
                break;
            case R.id.tab_toutiao:
                mViewPager.setCurrentItem(2);
                tabZhihu.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
                tabWangyi.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
                tabToutiao.setTextColor(mContext.getResources().getColor(R.color.colorRed));
                break;
        }
    }

    class MyPagerListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Log.d(MyUtils.TAG, "page position:"+position);
            switch (position) {
                case 0:
                    tabZhihu.setTextColor(mContext.getResources().getColor(R.color.colorRed));
                    tabWangyi.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
                    tabToutiao.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
                    break;
                case 1:
                    tabZhihu.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
                    tabWangyi.setTextColor(mContext.getResources().getColor(R.color.colorRed));
                    tabToutiao.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
                    break;
                case 2:
                    tabZhihu.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
                    tabWangyi.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
                    tabToutiao.setTextColor(mContext.getResources().getColor(R.color.colorRed));
                    break;
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
