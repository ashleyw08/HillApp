package com.example.hill;

import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

/*
THIS IS STILL A WORK IN PROGRESS. CURRENTLY NOT USING.
FOR NOW, I'M USING THE ACTION_WEB_SEARCH IN SELECT IRA CLASS.


 */
public class RothIraWebView extends AppCompatActivity {

    String rIraQuery = "www.google.com/search?q=open+roth+ira";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_roth_ira_web_view);

    }
}