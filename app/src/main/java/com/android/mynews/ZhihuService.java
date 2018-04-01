package com.android.mynews;

import com.android.mynews.beans.ZhihuBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2018/3/24.
 */

public interface ZhihuService {
    @GET("/api/4/news/latest")
    Observable<ZhihuBean> getZhihuDaily();

    @GET("/api/4/news/before/{date}")
    Observable<ZhihuBean> getTheDailyBefore(@Path("date") String date);
}
