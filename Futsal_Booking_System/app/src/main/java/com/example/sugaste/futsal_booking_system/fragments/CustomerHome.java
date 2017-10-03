package com.example.sugaste.futsal_booking_system.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.sugaste.futsal_booking_system.includes.UI;
import com.xudip.futsalbookingsystem.R;

public class CustomerHome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
               this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

//    start of action listeners like clikck.

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if(this.getClass().toString().equals("CustomerHome")){
            this.finish();
        }
        else {
            startActivity(new Intent(this, CustomerHome.class));
            this.finish();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        String itemSelected = item.toString();

        if(itemSelected.equals("Home")){
            getHomeFragment();
        }

        if(itemSelected.equals("Search Futsal")){
            getSearchFutsalFragment();
        }

        if(itemSelected.equals("Booked Futsal")){
            getBookedFutsalFragment();
        }

        if(itemSelected.equals("Near By Futsal")){

        }

        if(itemSelected.equals("Challenge Room")){
            getChallengeRoomFragment();
        }
        if(itemSelected.equals("Wishlist")){

        }
        if(itemSelected.equals("View Offers")){

        }
        if(itemSelected.equals("Settings")){

        }
        if(itemSelected.equals("Log Out")){

        }

        UI.PrintLogToLogCat("navigation", itemSelected);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getHomeFragment() {

    }

    public void actionSearchFutsalFragment(View v){
        getSearchFutsalFragment();
    }

    public void actionBookedFutsalFragment(View v1){
        getBookedFutsalFragment();
    }

    public void actionChallengeRoomFragment(View v2){
        getChallengeRoomFragment();
    }


//end of action listeners.
//    start of navigations of activities.

    public void getSearchFutsalFragment(){
        fragment = new SearchFutsal();
        updateFragment(fragment);
    }

    public void getBookedFutsalFragment(){
        fragment = new BookedFutsal();
        updateFragment(fragment);
        }

    public void getNearByFutsal(){

    }

    public void getChallengeRoomFragment(){
        fragment = new ChallengeRoom();
        updateFragment(fragment);
    }

    public void getWishList(){

    }

    public void getViewOffers(){

    }

    public void settings(){

    }

//    end of navigations

    private void updateFragment(Fragment fragment)
    {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();
    }


}
