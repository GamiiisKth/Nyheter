package com.nyheter.joshuapro.nyheter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


public class onload extends Activity {

    private final static String TAG = "ThreadingAsyncTask";

    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private int mDelay = 250;
    boolean af=false;
    boolean lo=true;
    Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onload);



            mImageView = (ImageView) findViewById(R.id.imageView);

            mProgressBar = (ProgressBar) findViewById(R.id.progressBar);


            new LoadIconTask().execute(R.layout.activity_favorit);

         intent = new Intent(this, Aftonbladet.class);



    }



    class LoadIconTask extends AsyncTask<Integer, Integer, Bitmap> {


        @Override
        protected void onPreExecute() {
            mProgressBar.setVisibility(ProgressBar.VISIBLE);

        }





        @Override
        protected Bitmap doInBackground(Integer... resId) {
            Bitmap tmp = BitmapFactory.decodeResource(getResources(), resId[0]);
            // simulating long-running operation
            for (int i = 1; i < 11; i++) {
                sleep();
                publishProgress(i * 10);
            }
            return tmp;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mProgressBar.setProgress(values[0]);

        }

        @Override
        protected void onPostExecute(Bitmap result) {
            mProgressBar.setVisibility(ProgressBar.INVISIBLE);
            mImageView.setImageBitmap(result);
           run();
            finish();

        }

        private void sleep() {
            try {
                Thread.sleep(mDelay);
            } catch (InterruptedException e) {
                Log.e(TAG, e.toString());
            }
        }
    }

    public void run(){

        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }

}
