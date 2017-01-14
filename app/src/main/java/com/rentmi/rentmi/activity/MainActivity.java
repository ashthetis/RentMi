package com.rentmi.rentmi.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.crashlytics.android.Crashlytics;
import com.rentmi.rentmi.R;
import com.rentmi.rentmi.fragment.*;
import io.fabric.sdk.android.Fabric;

/**
 * The main activity for the entire app. This activity manages a navigation drawer, and embeds the
 * other fragments of the app inside of a content frame.
 *S
 * @author Declan Hopkins
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private DrawerLayout m_drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Initialize Fabric for analytics and crash reporting
        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        m_drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, m_drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        m_drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Embed the default fragment
        embedFragment(HomeFragment.newInstance());
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.nav_home)
        {
            embedFragment(HomeFragment.newInstance());
        }
        if (id == R.id.nav_my_profile)
        {
            embedFragment(ProfileFragment.newInstance());
        }
        if (id == R.id.nav_my_rentals)
        {
            embedFragment(MyRentalFragment.newInstance());
        }
        if (id == R.id.nav_my_listings)
        {
            embedFragment(MyListingFragment.newInstance());
        }
        if (id == R.id.nav_revenue_hub)
        {
            embedFragment(RevenueHubFragment.newInstance());
        }
        if (id == R.id.nav_messages)
        {
            embedFragment(MessageFragment.newInstance());
        }
        if (id == R.id.nav_listings)
        {
            embedFragment(ListingFragment.newInstance());
        }


        m_drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    public void embedFragment(Fragment newFragment)
    {
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.content_frame, newFragment);
        tx.commit();
    }
}

