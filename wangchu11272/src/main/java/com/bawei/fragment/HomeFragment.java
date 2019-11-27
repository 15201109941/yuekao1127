package com.bawei.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bawei.adapter.MyAdapter;
import com.bawei.base.BaseFragment;
import com.bawei.base.BasePresenter;
import com.bawei.bean.News;
import com.bawei.presenter.Presenter;
import com.bawei.url.AppUrl;
import com.bawei.wangchu11272.MyView;
import com.bawei.wangchu11272.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/*
 *@auther:王楚
 *@Date: 2019/11/27
 *@Time:9:25
 *@Description:${DESCRIPTION}
 **/
public class HomeFragment extends BaseFragment {
    private List<News.ResultBean> list = new ArrayList<>();
    private RecyclerView recy;
    private Button btn_a;
    private EditText edit_a;
    @Override
    protected BasePresenter initmmPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View view) {
        //初始化控件
        recy=view.findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        btn_a=view.findViewById(R.id.brn_a);
        edit_a=view.findViewById(R.id.edit_a);
        //跳转
        edit_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), MyView.class);
                        startActivity(intent);
            }
        });
    }

    @Override
    protected int init() {
        return R.layout.left;
    }

    @Override
    protected void initcoming() {
        mmPresenter.startGetRequest(AppUrl.url);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onRuccess(String json) {
        //gson解析 和list集合
        List<News.ResultBean> li = new Gson().fromJson(json,News.class).getResult();
        list.addAll(li);
        //设置适配器
        MyAdapter myAdapter = new MyAdapter(getActivity(),list);
        recy.setAdapter(myAdapter);
    }

    @Override
    public void onErrors(String error) {

    }
}
