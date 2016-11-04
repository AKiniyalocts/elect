package com.akiniyalocts.electtestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.akiniyalocts.elect.Elect;
import com.akiniyalocts.elect.ElectActivity;
import com.akiniyalocts.elect.ElectDelegate;
import com.akiniyalocts.elect.electives.HasHomeAsUp;
import com.akiniyalocts.elect.electives.HasTitleToolbar;

public class MainActivity extends AppCompatActivity implements ElectDelegate.Listener, HasHomeAsUp, HasTitleToolbar{

    private ElectDelegate electDelegate;

    @Override
    public String title() {
        return "Awesome title";
    }

    @Override
    public Toolbar toolbar() {
        return toolbar;
    }

    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);


        electDelegate = new ElectDelegate(this);

        Elect elect = new Elect.Builder(this)
                .elect(this)
                .delegate(electDelegate)
                .build();

        elect.init();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        electDelegate.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onHomeAsUpPressed() {
        super.onBackPressed();
    }
}
