package com.bawei.presenter;

import com.bawei.Contract;
import com.bawei.base.BasePresenter;
import com.bawei.model.Model;

/*
 *@auther:王楚
 *@Date: 2019/11/27
 *@Time:9:20
 *@presenter层
 **/
public class Presenter extends BasePresenter {
    private Contract.Model model;
    @Override
    protected void initModel() {
        model=new Model();
    }

    @Override
    public void startGetRequest(String url) {
        model.doGet(url, new Contract.MyCallBack() {
            @Override
            public void onRuccess(String json) {
                getView().onRuccess(json);
            }

            @Override
            public void onErrors(String error) {
                getView().onErrors(error);
            }
        });
    }
}
