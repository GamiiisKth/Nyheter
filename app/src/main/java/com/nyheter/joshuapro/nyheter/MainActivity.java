package com.nyheter.joshuapro.nyheter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv= (TextView) findViewById( R.id.textView);
        registerForContextMenu(tv);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Aftonbladet:
                Toast.makeText(getApplicationContext(), "Aftonbladet", Toast.LENGTH_LONG).show();
                Intent afInent= new Intent(this,Aftonbladet.class);
                startActivity(afInent);

                return true;

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
}
