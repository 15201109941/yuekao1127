package com.bawei.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.Contract;

/*
 *@auther:王楚
 *@Date: 2019/11/27
 *@Time:9:12
 *@fragment基类
 **/
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements Contract.View {
    public P mmPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(init(), container, false);
        initView(view);
        mmPresenter=initmmPresenter();
        if (mmPresenter!=null){
            mmPresenter.onAttch(this);
        }
        return view;
    }

    protected abstract P initmmPresenter();

    protected abstract void initView(View view);

    protected abstract int init();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initcoming();
    }

    protected abstract void initcoming();

    protected abstract void initData();

}
