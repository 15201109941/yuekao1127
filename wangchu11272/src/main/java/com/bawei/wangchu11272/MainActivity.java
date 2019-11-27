package com.bawei.wangchu11272;

import android.support.annotation.BoolRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.fragment.HomeFragment;
import com.bawei.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private List<Fragment> fList = new ArrayList<>();
    private ViewPager view_pager;
    private RadioGroup group;

    @Override
    protected void startcoming() {

    }

    @Override
    protected BasePresenter initmPresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //初始化控件
        view_pager=findViewById(R.id.view_pager);
        group=findViewById(R.id.group);
        //添加fragment
        fList.add(new HomeFragment());
        view_pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fList.get(i);
            }

            @Override
            public int getCount() {
                return fList.size();
            }
        });
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                group.check(group.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.brn_a:
                        view_pager.setCurrentItem(0);
                        break;
                }
            }
        });
    }

    @Override
    protected int layoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void onRuccess(String json) {

    }

    @Override
    public void onErrors(String error) {

    }
}
