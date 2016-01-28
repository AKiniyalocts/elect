# elect
A commons library for Android to help you start your projects quickly. 
Elect acts as a helper that removes boiler plate code resulting from using various common widgets in Android resulting in clean, readable code.

```java
setContentView();
setActionBarDrawerToggle(); 
swipeRefresh.setColorResIds();
setSupportActionBar();
setHomeAsUp();

etc..
```
All of these are properly initialized in your base class, allowing you to focus on the important parts of your application. Elect is strictly opt-in. Only electives you implement will be initialized.

## Usage

Extend `ElectActivity`...
```java
public class MainActivity extends ElectActivity{}
```

Implement your desired electives...
```java
public class MainActivity extends ElectActivity implements HasDrawer{
    @Override
    public DrawerLayout drawerLayout() {
        return drawerLayout;
    }

    @Override
    public NavigationView navigationView() {
        return navigationView;
    }

    @Override
    public NavigationView.OnNavigationItemSelectedListener navigationListener() {
        return navigationListener;
    }

    @Override
    public String title() {
        return getString(R.string.app_name);
    }

    @Override
    public Toolbar toolbar() {
        return toolbar;
    }

    @Override
    public int contentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
```
Each elective you implement asks for the required attributes to find and initialize it in it's base class.


## Supported Electives

###HasContentView
```java
public class MainActivity extends ElectActivity implements HasContentView{

    @Override
    public int contentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
```

###HasToolbar
```java
public class MainActivity extends ElectActivity implements HasToolbar{
    
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public Toolbar toolbar() {
        return toolbar;
    }

    @Override
    public int contentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
```
###HasTitleToolbar
```java
public class MainActivity extends ElectActivity implements HasTitleToolbar{

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public Toolbar toolbar() {
        return toolbar;
    }

    @Override
    public String title() {
        return getString(R.string.app_name);
    }

    @Override
    public int contentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
```
###HasSwipeRefresh
```java
public class MainActivity extends ElectActivity implements HasSwipeRefresh, SwipeRefreshLayout.OnRefreshListener{

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public SwipeRefreshLayout refreshLayout() {
        return swipeRefreshLayout;
    }

    @Override
    public SwipeRefreshLayout.OnRefreshListener listener() {
        return this;
    }


    @Override
    public int[] colorResIds() {
        return new int[]{R.color.colorAccent, R.color.colorPrimary};
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onRefresh() {
        
    }
}
```
###HasDrawer
```java
public class MainActivity extends ElectActivity implements HasDrawer{
    @Override
    public DrawerLayout drawerLayout() {
        return drawerLayout;
    }

    @Override
    public NavigationView navigationView() {
        return navigationView;
    }

    @Override
    public NavigationView.OnNavigationItemSelectedListener navigationListener() {
        return navigationListener;
    }

    @Override
    public String title() {
        return getString(R.string.app_name);
    }

    @Override
    public Toolbar toolbar() {
        return toolbar;
    }

    @Override
    public int contentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
```
###HasHomeAsUp
```java
public class MainActivity extends ElectActivity implements HasHomeAsUp{
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
```
