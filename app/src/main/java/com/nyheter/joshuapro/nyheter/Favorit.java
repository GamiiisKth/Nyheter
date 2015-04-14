package com.nyheter.joshuapro.nyheter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Favorit extends ActionBarActivity {

    ListView listView1;
    //String contacts[]={"Ajay","Sachin","Sumit","Tarun","Yogesh"};
    ArrayList<String> favourites;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit);

        favourites = ((SaveAndRead) this.getApplication()).getFavourites();

        listView1=(ListView)findViewById(R.id.listView1);

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,favourites);
        listView1.setAdapter(adapter);

        // Register the ListView  for Context menu
        //registerForContextMenu(listView1);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), favourites.get(i), Toast.LENGTH_LONG).show();
            }
        });
        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return false;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        favourites = ((SaveAndRead) this.getApplication()).getFavourites();
        adapter.notifyDataSetChanged();


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        /*
        menu.setHeaderTitle("Select The Action");

        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "SMS");
        */
        //READ DATA LIKE THIS

    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Call"){
            Toast.makeText(getApplicationContext(), "calling code", Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="SMS"){
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;

    }
}
