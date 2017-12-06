package fr.busin.tmdbsample;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import fr.busin.tmdbsample.models.NavItem;

public class BaseDrawerActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mDrawerToggle;
    protected DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    RelativeLayout mDrawerPane;
    ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_favories);

        frameLayout = (FrameLayout) findViewById(R.id.content_frame);

        mNavItems.add(new NavItem("Film", "Movies", R.drawable.ic_star_black_24dp));
      mNavItems.add(new NavItem("Series", "series", R.drawable.ic_star_border_black_24dp));
       // mNavItems.add(new NavItem("Setting", "change your preferences", R.drawable.ic_android_black_24dp));*/
        mNavItems.add(new NavItem("About", "Know more about us", R.drawable.ic_code_black_24dp));

        // DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        // Populate the Navigtion Drawer with options
        mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        mDrawerList = (ListView) findViewById(R.id.navList);


        DrawerListAdapter adapter = new DrawerListAdapter(this, mNavItems);

        mDrawerList.setAdapter( adapter);


        // Drawer Item click listeners
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromDrawer(position);
            }
        });

    }

    private void selectItemFromDrawer(int position) {

        if (mNavItems.get(position).getmTitle().equals("Film")) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
        if (mNavItems.get(position).getmTitle().equals("Series")) {
            Intent intent = new Intent(this, SerieActivity.class);
            startActivity(intent);
        }
        if (mNavItems.get(position).getmTitle().equals("About")) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }


        // Close the drawer
        mDrawerLayout.closeDrawer(mDrawerPane);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}