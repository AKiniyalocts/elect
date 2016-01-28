package com.akiniyalocts.elect.electives;

import android.support.annotation.ColorRes;
import android.support.v4.widget.SwipeRefreshLayout;

/**
 * Created by anthonykiniyalocts on 1/23/16.
 */
public interface HasSwipeRefresh {

    SwipeRefreshLayout refreshLayout();

    SwipeRefreshLayout.OnRefreshListener listener();

    @ColorRes int[] colorResIds();
}
