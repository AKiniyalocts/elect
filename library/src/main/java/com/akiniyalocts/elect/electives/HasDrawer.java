package com.akiniyalocts.elect.electives;

import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

/**
 * Created by anthony on 12/30/15.
 */
public interface HasDrawer extends HasTitleToolbar{

    DrawerLayout drawerLayout();

    NavigationView navigationView();

    NavigationView.OnNavigationItemSelectedListener navigationListener();

    @StringRes int openTitle();

    @StringRes int closedTitle();

}
