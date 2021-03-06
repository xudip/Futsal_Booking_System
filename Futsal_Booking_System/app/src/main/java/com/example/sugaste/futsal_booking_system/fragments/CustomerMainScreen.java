package com.example.sugaste.futsal_booking_system.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.sugaste.futsal_booking_system.LoginActivity;
import com.example.sugaste.futsal_booking_system.includes.UI;
import com.xudip.futsalbookingsystem.R;

public class CustomerMainScreen extends AppCompatActivity
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
        getHomeFragment();

    }

//    start of action listeners like clikck.

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            getHomeFragment();
            //getFragmentManager().popBackStack("navigation", FragmentManager.POP_BACK_STACK_INCLUSIVE);
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
            this.finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        UI.PrintLogToLogCat("navigation", itemSelected);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getHomeFragment() {
        fragment = new HomeFragment();
        updateFragment(fragment);
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
        //ft.add(fragment, "navigation").addToBackStack("navigation");
        ft.commit();
    }
    public void getAlertDialog(String msg, boolean okButtonVisibilityOnly){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(msg);
        if(okButtonVisibilityOnly) {
            alertDialogBuilder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
        }

        else{
            alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialogBuilder.setPositiveButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
        }
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
