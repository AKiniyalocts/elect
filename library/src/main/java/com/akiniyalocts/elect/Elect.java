package com.akiniyalocts.elect;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import com.akiniyalocts.elect.electives.Elective;
import com.akiniyalocts.elect.electives.HasDrawer;
import com.akiniyalocts.elect.electives.HasHomeAsUp;
import com.akiniyalocts.elect.electives.HasSwipeRefresh;
import com.akiniyalocts.elect.electives.HasTitleToolbar;
import com.akiniyalocts.elect.electives.HasToolbar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthonykiniyalocts on 11/3/16.
 */

public class Elect {

    private final AppCompatActivity appCompatActivity;

    private List<Elective> electives;

    private ElectDelegate delegate;

    private Elect(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    private void setElectives(List<Elective> electives){
        this.electives = electives;
    }

    public void setDelegate(ElectDelegate delegate) {
        this.delegate = delegate;
    }


    public void init(){
        if(appCompatActivity != null) {

            if(electives != null && !electives.isEmpty()){

                for(Elective elective : electives) {

                    if(elective instanceof HasDrawer){
                        initHasDrawer((HasDrawer)elective);
                    }

                    if(elective instanceof HasHomeAsUp){
                        initHasHomeAsUp((HasHomeAsUp)elective);
                    }

                    if(elective instanceof HasSwipeRefresh){
                        initSwipeRefresh((HasSwipeRefresh)elective);
                    }

                    if(elective instanceof HasTitleToolbar){
                        initTitleToolbar((HasTitleToolbar)elective);
                    }

                    if(elective instanceof HasToolbar){
                        initToolbar((HasToolbar)elective);
                    }

                }
            }

        }
        else {
            throw new IllegalArgumentException("Activity cannot be null.");
        }
    }

    private void initHasDrawer(HasDrawer hasDrawer) {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this.appCompatActivity, hasDrawer.drawerLayout(), hasDrawer.toolbar(), hasDrawer.openTitle(), hasDrawer.closedTitle());

        hasDrawer.drawerLayout().setDrawerListener(toggle);
        toggle.syncState();

        hasDrawer.navigationView().setNavigationItemSelectedListener(hasDrawer.navigationListener());


        if(this.appCompatActivity.getSupportActionBar() != null){
            this.appCompatActivity.getSupportActionBar().setTitle(hasDrawer.title());
        }
    }

    private void initHasHomeAsUp(HasHomeAsUp hasHomeAsUp) {
        if(hasHomeAsUp != null){
            if(this.appCompatActivity.getSupportActionBar() != null){
                this.appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    private void initTitleToolbar(HasTitleToolbar hasTitleToolbar) {
        if(hasTitleToolbar != null){
            if(this.appCompatActivity.getSupportActionBar() == null){
                this.appCompatActivity.setSupportActionBar(hasTitleToolbar.toolbar());
            }
            this.appCompatActivity.getSupportActionBar().setTitle(hasTitleToolbar.title());
        }
    }

    private void initToolbar(HasToolbar hasToolbar) {
        if(hasToolbar != null){
            if(this.appCompatActivity.getSupportActionBar() == null) {
                this.appCompatActivity.setSupportActionBar(hasToolbar.toolbar());
            }
        }
    }

    private void initSwipeRefresh(HasSwipeRefresh hasSwipeRefresh){
        if(hasSwipeRefresh.refreshLayout() != null) {
            hasSwipeRefresh.refreshLayout().setColorSchemeResources(hasSwipeRefresh.colorResIds());
            hasSwipeRefresh.refreshLayout().setOnRefreshListener(hasSwipeRefresh.listener());
        }
    }


    public static class Builder{

        private List<Elective> electives;

        private ElectDelegate electDelegate;

        private Elect elect;

        public Builder(AppCompatActivity activity){
            elect = new Elect(activity);
            electives = new ArrayList<>();
        }

        public Builder elect(Elective elective){
            electives.add(elective);
            return this;
        }

        public Builder delegate(ElectDelegate delegate){
            this.electDelegate = delegate;
            return this;
        }

        public Elect build() {
            elect.setElectives(electives);
            elect.setDelegate(electDelegate);

            return elect;
        }
    }
}
