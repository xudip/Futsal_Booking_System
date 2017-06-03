package com.example.sugaste.futsal_booking_system;

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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

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
            Toast.makeText(this, "Closing Navigation bar.", Toast.LENGTH_SHORT).show();

        }
        else if(this.getClass().toString().equals("CustomerHome")){
            this.finish();
            Toast.makeText(this,"Exited From Home only.", Toast.LENGTH_SHORT).show();
        }
        else {
            startActivity(new Intent(this, CustomerHome.class));
            this.finish();
            Toast.makeText(this, "Back Presed.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        String itemSelected = item.toString();
        Toast.makeText(this,itemSelected, Toast.LENGTH_SHORT).show();

        if(itemSelected.equals("Home")){
            Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
        }

        if(itemSelected.equals("Search Futsal")){
            Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
            getSearchFutsal();
        }

        if(itemSelected.equals("Booked Futsal")){
            Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
            getBookedFutsal();
        }

        if(itemSelected.equals("Near By Futsal")){
            Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
        }

        if(itemSelected.equals("Challenge Room")){
            Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
            getChallengeRoom();
        }
        if(itemSelected.equals("Wishlist")){
            Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
        }
        if(itemSelected.equals("View Offers")){
            Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
        }
        if(itemSelected.equals("Settings")){
            Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
        }
        if(itemSelected.equals("Log Out")){
            Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void actionSearchFutsal(View v){
        getSearchFutsal();
    }

    public void actionBookedFutsal(View v1){
        getBookedFutsal();
    }

    public void actionChallengeRoom(View v2){
        getChallengeRoom();
    }


//end of action listeners.
//    start of navigations of activities.

    public void getSearchFutsal(){
        fragment = new SearchFutsal();
        updateFragment(fragment);
    }

    public void getBookedFutsal(){
        fragment = new BookedFutsal();
        updateFragment(fragment);
        }

    public void getNearByFutsal(){

    }

    public void getChallengeRoom(){
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
