package com.bawei.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.bean.News;
import com.bawei.util.GlideUtil;
import com.bawei.wangchu11272.R;

import java.util.List;

/*
 *@auther:王楚
 *@Date: 2019/11/27
 *@Time:9:37
 *@D适配器
 **/
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<News.ResultBean> list;

    private final int DAN=1;
    private final int SHUANG=2;
    public MyAdapter(Context context, List<News.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //获取.xml布局
        RecyclerView.ViewHolder holder = null;
        if (i==DAN){
            View view = View.inflate(context, R.layout.dan, null);
            holder=new danHolder(view);
        }else if (i==SHUANG){
            View view = View.inflate(context, R.layout.shuang, null);
            holder=new shuangHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        //传值
        if (viewHolder instanceof danHolder){
            GlideUtil.loadImage(list.get(i).getMasterPic(),((danHolder) viewHolder).dan_img);
            ((danHolder) viewHolder).dan_name.setText(list.get(i).getCommodityName());
            ((danHolder) viewHolder).dan_price.setText(list.get(i).getPrice()+"");
        }else if (viewHolder instanceof shuangHolder){
            GlideUtil.loadImage(list.get(i).getMasterPic(),((shuangHolder) viewHolder).shuang_img);
            ((shuangHolder) viewHolder).shuang_name.setText(list.get(i).getCommodityName());
            ((shuangHolder) viewHolder).shuang_price.setText(list.get(i).getPrice()+"");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        //判断
        int commodityId = list.get(position).getCommodityId();
        if (commodityId%2==0){
            return DAN;
        }else if (commodityId%2!=0){
            return SHUANG;
        }
        return super.getItemViewType(position);
    }
    //初始化控件
    class shuangHolder extends RecyclerView.ViewHolder{
        private ImageView shuang_img;
        private TextView shuang_name;
        private TextView shuang_price;
        public shuangHolder(@NonNull View itemView) {
            super(itemView);
            shuang_img = itemView.findViewById(R.id.shuang_img);
            shuang_name = itemView.findViewById(R.id.shuang_name);
            shuang_price = itemView.findViewById(R.id.shuang_price);
        }
    }
    class danHolder extends RecyclerView.ViewHolder{
        private ImageView dan_img;
        private TextView dan_name;
        private TextView dan_price;
        public danHolder(@NonNull View itemView) {
            super(itemView);
            dan_img=itemView.findViewById(R.id.dan_img);
            dan_name=itemView.findViewById(R.id.dan_name);
            dan_price=itemView.findViewById(R.id.dan_price);
        }
    }
}
