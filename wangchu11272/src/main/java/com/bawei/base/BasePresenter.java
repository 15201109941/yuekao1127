package com.bawei.base;

import com.bawei.Contract;

import java.lang.ref.WeakReference;

/*
 *@auther:王楚
 *@Date: 2019/11/27
 *@Time:9:12
 *@presenter基类
 **/
public abstract class BasePresenter<V extends Contract.View> implements Contract.Presenter {
    public WeakReference<V> mWeak;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
    protected void onAttch(V view){
        mWeak=new WeakReference<>(view);
    }
    protected void onDeAttch(){
        if (mWeak!=null){
            mWeak.clear();
            mWeak=null;
        }
    }
    public V getView(){
        return mWeak.get();
    }
}
