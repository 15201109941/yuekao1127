package com.bawei;

/*
 *@auther:王楚
 *@Date: 2019/11/27
 *@Time:9:09
 *@契约类
 **/
public interface Contract {
    interface MyCallBack{
        void onRuccess(String json);
        void onErrors(String error);
    }
    //model层
    interface Model{
        void doGet(String url , MyCallBack myCallBack);
    }
    //view层
    interface View{
        void onRuccess(String json);
        void onErrors(String error);
    }
    //presenter层
    interface Presenter{
        void startGetRequest(String url);
    }
}
