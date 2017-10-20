package com.jpalle.watch_web;

/**
 * Created by jpalle
 */

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.Activity;
import android.widget.ProgressBar;
import android.view.View;

public class MainActivity extends Activity {
    private ProgressDialog mprogress;
    private WebView myWebView;
    private WebSettings mysettings;
    private ProgressBar spinner;
    String ShowOrHideWebViewInitialUse = "show";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.webview);
        spinner = (ProgressBar) findViewById(R.id.loading);
        mysettings = myWebView.getSettings();
        mysettings.setJavaScriptEnabled(true);
        mysettings.setBuiltInZoomControls(true);
        mysettings.setDisplayZoomControls(false);
        myWebView.setWebViewClient(new MyWebviewClient(mprogress));
        myWebView.loadUrl("Plcae Your Url Here");
        myWebView.canGoBack();
    }

    @Override
    protected void onResume(){
        super.onResume();
        initWidgets();
    }

    public void initWidgets(){
        mprogress = new ProgressDialog(this);
        mprogress.setCancelable(false);
        mprogress.setMessage(" Loading!  Please Wait..");
        mprogress.show();
    }

    private class MyWebviewClient extends WebViewClient{

        public MyWebviewClient(ProgressDialog progress){
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            if (ShowOrHideWebViewInitialUse.equals("show")) {
                myWebView.setVisibility(myWebView.INVISIBLE);
                super.onPageStarted(view, url, favicon);
            }
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            ShowOrHideWebViewInitialUse="hide";
            spinner.setVisibility(View.GONE);
            view.setVisibility(myWebView.VISIBLE);
            super.onPageFinished(view, url);
            mprogress.dismiss();
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl){
            myWebView.loadUrl("file:///android_asset/error.html");
        }
    }
}
