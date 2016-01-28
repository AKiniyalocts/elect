package com.akiniyalocts.elect;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import com.akiniyalocts.elect.electives.HasContentView;
import com.akiniyalocts.elect.electives.HasDrawer;
import com.akiniyalocts.elect.electives.HasHomeAsUp;
import com.akiniyalocts.elect.electives.HasSwipeRefresh;
import com.akiniyalocts.elect.electives.HasTitleToolbar;
import com.akiniyalocts.elect.electives.HasToolbar;
import butterknife.ButterKnife;

public abstract class ElectActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(this instanceof HasContentView){
            setContentView(((HasContentView)this).contentView());
            ButterKnife.bind(this);
        }

        if(this instanceof HasToolbar){
            initActionBar();
        }

        if(this instanceof HasDrawer){
            initDrawer();
        }

        if(this instanceof HasSwipeRefresh){
            initSwipeRefresh();
        }

    }

    private void initActionBar(){

        if(this instanceof HasToolbar){
            HasToolbar hasToolbar = (HasToolbar) this;

            setSupportActionBar(hasToolbar.toolbar());

            if(this instanceof HasHomeAsUp){
                setHomeAsUp();
            }

            if(this instanceof HasTitleToolbar){
                setTitle(((HasTitleToolbar) this).title());
            }
        }
    }

    private void initDrawer(){
        HasDrawer hasDrawer = (HasDrawer) this;

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, hasDrawer.drawerLayout(), hasDrawer.toolbar(), R.string.app_name, R.string.app_name);

        hasDrawer.drawerLayout().setDrawerListener(toggle);
        toggle.syncState();

        hasDrawer.navigationView().setNavigationItemSelectedListener(hasDrawer.navigationListener());


        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(hasDrawer.title());
        }
    }

    private void initSwipeRefresh() {

        HasSwipeRefresh hasSwipeRefresh = (HasSwipeRefresh) this;

        if(hasSwipeRefresh.refreshLayout() != null) {
            hasSwipeRefresh.refreshLayout().setColorSchemeResources(hasSwipeRefresh.colorResIds());

            hasSwipeRefresh.refreshLayout().setOnRefreshListener(hasSwipeRefresh.listener());
        }

    }

    protected void setHomeAsUp(){
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
    }

    @Override
    public void onBackPressed() {
        if(this instanceof HasDrawer){
            HasDrawer hasDrawer = (HasDrawer) this;

            if (hasDrawer.drawerLayout().isDrawerOpen(GravityCompat.START)) {
                hasDrawer.drawerLayout().closeDrawer(GravityCompat.START);
            }
            else{
                super.onBackPressed();
            }
        }
        else {
            super.onBackPressed();
        }

    }

    @Override
    protected void onDestroy() {
        if(this instanceof HasContentView) {
            ButterKnife.unbind(this);
        }

        super.onDestroy();
    }

}
