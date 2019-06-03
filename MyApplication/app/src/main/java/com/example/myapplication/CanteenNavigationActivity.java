package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

public class CanteenNavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    boolean userclickonbackbutton = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.contentfooditem, new Punjabi_food());
        ft.commit();

        setContentView(R.layout.activity_canteen_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        //    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //  if (drawer.isDrawerOpen(GravityCompat.START)) {
        //    drawer.closeDrawer(GravityCompat.START);
        if (!userclickonbackbutton) {
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
            userclickonbackbutton = true;
            //Toast.makeText(Fooditems_nav_act.this, "Logout Successfully...", Toast.LENGTH_SHORT).show();
        } else {
            super.onBackPressed();
        }
        new CountDownTimer(2000, 1000) {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                userclickonbackbutton = false;
            }
        }.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.canteen_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            startActivity(new Intent(CanteenNavigationActivity.this, StudentPanel.class));
            finish();
        }
        if (id == R.id.action_home) {
            startActivity(new Intent(CanteenNavigationActivity.this, MainActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.punjabifood) {
            android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Punjabi_food punjabi_food = new Punjabi_food();
            ft.replace(R.id.contentfooditem, punjabi_food);
            ft.commit();
        } else if (id == R.id.snacksfood) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            Snacks_fragment snacks_fragment = new Snacks_fragment();
            ft.replace(R.id.contentfooditem, snacks_fragment);
            ft.commit();

        } else if (id == R.id.sweetsfood) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            sweets_fragment sweets_fragment = new sweets_fragment();
            ft.replace(R.id.contentfooditem, sweets_fragment);
            ft.commit();

        } else if (id == R.id.nav_order) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.contentfooditem, new order());
            ft.commit();
        } else if (id == R.id.nav_gallery) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.contentfooditem, new Gallery());
                ft.commit();

            } else if (id == R.id.nav_share) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Hello...how are you.");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, "Share..."));

            } else if (id == R.id.nav_feedback) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.contentfooditem, new Feedbackfragment());
                ft.commit();


            }

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }
