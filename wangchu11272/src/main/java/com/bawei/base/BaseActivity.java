package com.bawei.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bawei.Contract;

/*
 *@auther:王楚
 *@Date: 2019/11/27
 *@Time:9:12
 *@base基类 **/
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contract.View {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutID()!=0){
            setContentView(layoutID());
            initView();
            initData();
            mPresenter=initmPresenter();
            if (mPresenter!=null){
                mPresenter.onAttch(this);
            }
            startcoming();
        }
    }

    protected abstract void startcoming();

    protected abstract P initmPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutID();
    //防止内存溢出

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.onDeAttch();
            mPresenter=null;
        }
    }
}
