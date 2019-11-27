package com.bawei.util;

import android.widget.ImageView;

import com.bawei.app.AppContext;
import com.bawei.wangchu11272.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/*
 *@auther:王楚
 *@Date: 2019/11/27
 *@Time:9:00
 *@设置图片的引用
 **/
public class GlideUtil {
    public static void loadImage(String url, ImageView imageView){
        Glide.with(AppContext.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(5)))
                //优先级
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
