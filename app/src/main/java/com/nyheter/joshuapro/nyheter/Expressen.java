package com.nyheter.joshuapro.nyheter;

import android.annotation.SuppressLint;
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


public class Expressen extends ActionBarActivity {

    WebView mWebView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expressen);

        mWebView = (WebView) findViewById(R.id.webview_Expressen);

        // Set a kind of listener on the WebView so the WebView can intercept
        // URL loading requests if it wants to

        mWebView.setWebViewClient(new HelloWebViewClient());

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://www.expressen.se");
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
        getMenuInflater().inflate(R.menu.menu_expressen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Home:
                Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_LONG).show();
                Intent afInent= new Intent(this,MainActivity.class);
                startActivity(afInent);

                return true;

            case R.id.ex_Aftonbladet:
                Toast.makeText(getApplicationContext(), "Aftonbladet", Toast.LENGTH_LONG).show();
                Intent intent= new Intent(this,Aftonbladet.class );
                startActivity(intent);
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
