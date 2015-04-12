package com.nyheter.joshuapro.nyheter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class Aftonbladet extends ActionBarActivity {

    WebView mWebView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aftonbladet);

        mWebView = (WebView) findViewById(R.id.webview_Aftonbladet);

        // Set a kind of listener on the WebView so the WebView can intercept
        // URL loading requests if it wants to

        mWebView.setWebViewClient(new HelloWebViewClient());

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://www.aftonbladet.se");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_aftonbladet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Home:
                Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_LONG).show();
                Intent home= new Intent(this,MainActivity.class);
                startActivity(home);

                return true;

            case R.id.Expressen:
                Toast.makeText(getApplicationContext(), "Expressen", Toast.LENGTH_LONG).show();
                Intent ex_intent= new Intent(this, Expressen.class);
                startActivity(ex_intent);
                return true;

            case R.id.Dn:
                Toast.makeText(getApplicationContext(), "DagensNyhter", Toast.LENGTH_LONG).show();
                return  true;
            case R.id.DagensTv :
                return  true;

            default:
                return  false;
        }
    }

    private class HelloWebViewClient extends WebViewClient {
        private static final String TAG = "HelloWebViewClient";;

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.i(TAG, "About to load:" + url);
            view.loadUrl(url);
            return true;
        }
    }
}
