package com.android.mynews.presenters;

import android.content.Context;
import android.util.Log;

import com.android.mynews.ZhihuService;
import com.android.mynews.beans.ZhihuBean;
import com.android.mynews.fragments.ZhihuFragment;
import com.android.mynews.utils.MyUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/3/25.
 */

public class ZhihuPresenterImp implements IZhihuPresenter {
    Context mContext;
    ZhihuFragment mZhihuFragment;
    Retrofit mRetrofit;
    ZhihuService mZhihuService;

    public ZhihuPresenterImp(Context context, ZhihuFragment zhihuFragment) {
        mContext = context;
        mZhihuFragment = zhihuFragment;
    }

    public Retrofit getRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return mRetrofit;
    }

    @Override
    public void getZhihuDailyLatest() {
        mZhihuService = getRetrofit().create(ZhihuService.class);
        mZhihuService.getZhihuDaily()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhihuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(MyUtils.TAG, "--onSubscribe ");
                    }

                    @Override
                    public void onNext(ZhihuBean zhihuBean) {
                        Log.d(MyUtils.TAG, "--onNext " + zhihuBean.getDate() + ", " + zhihuBean.getStories().size());
                        mZhihuFragment.updateZhihuDailyBeans(zhihuBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(MyUtils.TAG, "--onError: " + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(MyUtils.TAG, "--onComplete ");
                    }
                });
    }

    @Override
    public void getTheDailyBefore(String date) {
        if (mZhihuService==null) {
            mZhihuService = getRetrofit().create(ZhihuService.class);
        }
        Log.d(MyUtils.TAG, "--getTheDailyBefore date="+date);
        mZhihuService.getTheDailyBefore(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhihuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(MyUtils.TAG, "getTheDailyBefore onSubscribe");
                    }

                    @Override
                    public void onNext(ZhihuBean zhihuBean) {
                        if(zhihuBean!=null)
                            Log.d(MyUtils.TAG, "getTheDailyBefore size:"+zhihuBean.getStories().size());
                        mZhihuFragment.updateZhihuDailyBeans(zhihuBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(MyUtils.TAG, "getTheDailyBefore onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(MyUtils.TAG, "getTheDailyBefore onComplete");
                    }
                });
    }
}
