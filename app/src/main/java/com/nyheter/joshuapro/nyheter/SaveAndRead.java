package com.nyheter.joshuapro.nyheter;

import android.app.Application;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by joshuapro on 15-04-13.
 */
public class SaveAndRead extends Application{

    ArrayList<String> favourites = new ArrayList<String>();

    public ArrayList<String> getFavourites(){
        return favourites;
    }

    public void addToFavourites(String favourite){
        favourites.add(favourite);
    }



}
