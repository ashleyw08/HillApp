package com.example.hill;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
STILL A WORK IN PROGRESS. CURRENTLY NOT USING.
 */
public class IraWebView extends AppCompatActivity
{
   WebView iraWebView;
   Boolean canGoBack;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_ira_web_view);
        //find webview
        //iraWebView = findViewById(R.id.iraWebViewId);
       // iraWebView.getSettings().setJavaScriptEnabled(true);
        //iraWebView.loadUrl(tIraQuery);
        //canGoBack = iraWebView.canGoBack();
    }
}
