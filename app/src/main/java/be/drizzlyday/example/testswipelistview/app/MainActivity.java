package be.drizzlyday.example.testswipelistview.app;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.example.testswipelistview.app.R;

import be.drizzlyday.example.testswipelistview.app.adapters.MenuAdapter;


public class MainActivity extends SherlockFragmentActivity implements AdapterView.OnItemClickListener {

    private ListView menuList;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private MenuAdapter menuAdapter;

    private CharSequence title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.GREEN));
        title = getTitle();
        menuList = (ListView) findViewById(R.id.menu_list);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(title);
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(R.string.app_name);
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        menuAdapter = new MenuAdapter(this, R.layout.row_menu, getResources().getStringArray(R.array.menu_items));
        menuList.setAdapter(menuAdapter);
        menuList.setOnItemClickListener(this);

        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.add(R.id.content_frame, new ListFragment(), getResources().getString(R.string.app_name));
        t.commit();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Log.d("MenuOption", "OnClick menu option: " + position);
        drawerLayout.closeDrawer(menuList);
    }
}
