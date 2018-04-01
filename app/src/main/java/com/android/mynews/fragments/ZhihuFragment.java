package com.android.mynews.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.mynews.R;
import com.android.mynews.ZhihuService;
import com.android.mynews.adapter.MyNewsAdapter;
import com.android.mynews.beans.ZhihuBean;
import com.android.mynews.presenters.IZhihuPresenter;
import com.android.mynews.presenters.ZhihuPresenterImp;
import com.android.mynews.utils.MyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/3/26.
 */

//@SuppressLint("ValidFragment")
public class ZhihuFragment extends Fragment {
    @BindView(R.id.zhihu_recycler)
    RecyclerView zhihuRecycler;
    Unbinder unbinder;
    Context mContext;
    MyNewsAdapter myNewsAdapter;
    ZhihuBean mZhihuBean;
    LinearLayoutManager mLinearLayoutManager;
    IZhihuPresenter mZhihuPresenter;
    boolean loading;

//    public ZhihuFragment(Context context){
//        mContext = context;
//        Log.d(MyUtils.TAG, "--ZhihuFragment ");
//    }
    public ZhihuFragment(){
        Log.d(MyUtils.TAG, "--ZhihuFragment ");
    }

    @Override
    public boolean getUserVisibleHint() {
        Log.d(MyUtils.TAG, "--getUserVisibleHint ");
        return super.getUserVisibleHint();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(MyUtils.TAG, "--onCreate ");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d(MyUtils.TAG, "--onCreateView ");
        View view = inflater.inflate(R.layout.fragment_zhihu, container, false);
        unbinder = ButterKnife.bind(this, view);
        if (zhihuRecycler == null) {
            Log.d(MyUtils.TAG, "--onCreateView zhihuRecycler is null");
            zhihuRecycler = view.findViewById(R.id.zhihu_recycler);
        }
        init();
        return view;
    }

    public void init() {
        mContext = getActivity();
        myNewsAdapter = new MyNewsAdapter(mContext, null);
        mLinearLayoutManager = new LinearLayoutManager(mContext);
        zhihuRecycler.setLayoutManager(mLinearLayoutManager);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        zhihuRecycler.addItemDecoration(new RecycleViewDivider(mContext, LinearLayoutManager.VERTICAL));
        zhihuRecycler.setAdapter(myNewsAdapter);
        mZhihuPresenter = new ZhihuPresenterImp(mContext, this);
        mZhihuPresenter.getZhihuDailyLatest();

        zhihuRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleCount = mLinearLayoutManager.getChildCount();
                int totalCount = mLinearLayoutManager.getItemCount();
                int firstVisibleItemPosition = mLinearLayoutManager.findFirstVisibleItemPosition();
                Log.d(MyUtils.TAG, "onScrolled() first="+firstVisibleItemPosition+", visible="+visibleCount+", total="+totalCount);
                if (!loading && (firstVisibleItemPosition + visibleCount) >= totalCount) {
                    loadMoreNews();
                }
            }
        });
    }

    public void loadMoreNews() {
        loading = true;
        myNewsAdapter.loadingStart();
        mZhihuPresenter.getTheDailyBefore(mZhihuBean.getDate());
    }

    public void updateZhihuDailyBeans(ZhihuBean zhihuBean) {
        loading = false;
        myNewsAdapter.loadingFinish();
        Log.d(MyUtils.TAG, "zhihuBean==? "+(zhihuBean==null));
        mZhihuBean = zhihuBean;
        myNewsAdapter.updateAdapter(zhihuBean);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
