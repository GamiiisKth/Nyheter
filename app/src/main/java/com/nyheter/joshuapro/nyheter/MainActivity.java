package com.nyheter.joshuapro.nyheter;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {
    WebView af;
    WebView ex;
    WebView dn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        //    dn=(WebView) findViewById(R.id.dn_main);

        //  af = (WebView) findViewById(R.id.af_main);


        //setContentView(R.layout.activity_aftonbladet);
        // Set a kind of listener on the WebView so the WebView can intercept
        // URL loading requests if it wants to

        //  af.setWebViewClient(new HelloWebViewClient());

        //af.getSettings().setJavaScriptEnabled(true);
        //af.loadUrl("http://www.aftonbladet.se/?latest=true");

        // loadIcon();




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();

        //TODO - Här ska data sparas till interna minnet på mobilen


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Aftonbladet:
                Toast.makeText(getApplicationContext(), "Aftonbladet", Toast.LENGTH_LONG).show();
                Intent afInent= new Intent(this,onload.class);
                startActivity(afInent);

                return true;

            case R.id.favorit:
                Intent fa_intent= new Intent( this, Favorit.class);
                startActivity(fa_intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                return  true;


            case R.id.Expressen:
                Toast.makeText(getApplicationContext(), "Expressen", Toast.LENGTH_LONG).show();
                Intent ex_intent=new Intent(this, Expressen.class);
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
    /*
        private void loadIcon() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ex=(WebView) findViewById(R.id.ex_main);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    ex.post(new Runnable() {
                        @Override
                        public void run() {
                      ex.setWebViewClient(new HelloWebViewClient());

                  ex.getSettings().setJavaScriptEnabled(true);
                  ex.loadUrl("http://www.Expressen.se");
                        }
                    });
                }
            }).start();

        }
    */
    private class HelloWebViewClient extends WebViewClient {
        private static final String TAG = "HelloWebViewClient";

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.i(TAG, "About to load:" + url);
            view.loadUrl(url);


            return true;
        }
    }











}
