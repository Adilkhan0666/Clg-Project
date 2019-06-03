package com.example.myapplication;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class UptuCircular extends AppCompatActivity {
    WebView wv;
    SwipeRefreshLayout swipeRefreshLayout;
    Button button;
    String url="https://aktu.ac.in/circulars.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uptu_circular);
        wv = findViewById(R.id.uptu_circular_webview);
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv.loadUrl(url);
        wv.setWebViewClient(new WebViewClient());//by using this method webpage open in your app

    }
}