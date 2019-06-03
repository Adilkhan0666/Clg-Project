package com.example.myapplication;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class AktuResult extends AppCompatActivity {
    WebView wv;
    SwipeRefreshLayout swipeRefreshLayout;
    Button button;
    String url="https://erp.aktu.ac.in/webpages/oneview/oneview.aspx";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktu_result);

        wv = findViewById(R.id.aktu_result_webview);
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv.loadUrl(url);
        wv.setWebViewClient(new WebViewClient());//by using this method webpage open in your app

    }
}