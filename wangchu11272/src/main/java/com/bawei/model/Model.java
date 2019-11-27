package com.bawei.model;

import com.bawei.Contract;
import com.bawei.util.HttpUtil;

/*
 *@auther:王楚
 *@Date: 2019/11/27
 *@Time:9:11
 *@model层
 **/
public class Model implements Contract.Model {
    @Override
    public void doGet(String url, final Contract.MyCallBack myCallBack) {
        HttpUtil.getInstance().doGet(url, new HttpUtil.MyCallBack() {
            @Override
            public void onRuccess(String json) {
                myCallBack.onRuccess(json);
            }

            @Override
            public void onError(String error) {
                myCallBack.onErrors(error);
            }
        });
    }
}
