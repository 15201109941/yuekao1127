package com.bawei.url;

import java.net.URLEncoder;

/*
 *@auther:王楚
 *@Date: 2019/11/27
 *@Time:9:35
 *@设置接口
 **/
public interface AppUrl {
    String url="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+URLEncoder.encode("板鞋")+"&page=1&count=5";
}
