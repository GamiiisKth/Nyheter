package com.nyheter.joshuapro.nyheter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

/**
 * Created by joshuapro on 15-04-16.
 */
public class WebViewaActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {


        //Note that getIntent() still returns the original Intent. You can use setIntent(Intent) to update it to this new Intent.
        Intent intent = getIntent();
        ImageView imageView= new ImageView(getApplicationContext());
        // komma åt image från grid för att visa
        imageView.setImageResource(intent.getIntExtra(Grid.EXTRA_RES_ID, -1));
        // set IU view som ska visas
        setContentView(imageView);

    }
}
