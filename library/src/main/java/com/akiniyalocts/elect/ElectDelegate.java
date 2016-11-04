package com.akiniyalocts.elect;

import android.view.MenuItem;

/**
 * Created by anthonykiniyalocts on 11/4/16.
 */

public class ElectDelegate {

    public interface Listener{
        void onHomeAsUpPressed();
    }

    private final Listener listener;

    public ElectDelegate(Listener electDelegateListener){
        this.listener = electDelegateListener;
    }

    public void onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            listener.onHomeAsUpPressed();
        }
    }

}
