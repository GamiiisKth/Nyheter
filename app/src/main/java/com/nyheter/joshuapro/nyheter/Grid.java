package com.nyheter.joshuapro.nyheter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;


public class Grid extends Fragment {
    protected static final String EXTRA_RES_ID = "POS";

    // list antingen flower eller animals
    private List<Integer> mThumbNailIDs;
    private GridView mGridview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mThumbNailIDs = getArguments().getIntegerArrayList(MainActivity.THUMBNAIL_IDS);

    }

    /**************************************onActivityCreated***********************************************/
    //onActivityCreated
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // imageAdapter
        //  getActivity() in a Fragment returns the Activity the Fragment is currently associated with. antigen flower eller animals

        // denna identifierar
        mGridview.setAdapter(new WebviewAdapter(getActivity(), mThumbNailIDs));

        // GridView som håller alla bilder anitgen flower eller animals
        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            /*Parameters  onItemClick
parent	        The AdapterView where the click happened.
view	        The view within the AdapterView that was clicked (this will be a view provided by the adapter)
position	    The position of the view in the adapter.
id	            The row id of the item that was clicked.*/

            // ImageView för dem image som har klickat
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                //Return the Activity this fragment is currently associated with.
                Intent intent = new Intent(getActivity(),
                        // ImageViewActivity
                        WebViewaActivity.class);


                //string som kärntecknar meddelande, id är den image som har blivit  klickat
                //putExtra tillhör bundle , man kommunicerar med andra activiy i detta fall ImageViewActivity
                // skickar meddelande och bildens rad
                intent.putExtra(EXTRA_RES_ID, (int) id);
                startActivity(intent);
            }
        });
    }

    /****************************************onCreateView*********************************************/


    //Called to have the fragment instantiate its user interface view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_grid, container, false);
        mGridview = (GridView) view.findViewById(R.id.gridview);
        return view;
    }

}
