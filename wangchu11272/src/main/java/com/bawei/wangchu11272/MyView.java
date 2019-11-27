package com.bawei.wangchu11272;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import java.security.acl.Group;

public class MyView extends LinearLayout {
    private WebView webView;
    private MyView myView;
    private Group group;


    public MyView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    @SuppressLint("JavascriptInterface")
    private void initView() {
        myView=findViewById(R.id.MyView);
        group=findViewById(R.id.group);
        webView=findViewById(R.id.webView);
        //js交互
        webView.loadUrl("file:///C:/Users/王楚/Desktop/info.html");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
       // webView.addJavascriptInterface(new MyApp,"viewport");
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }
    class MyApp{

    }
}
