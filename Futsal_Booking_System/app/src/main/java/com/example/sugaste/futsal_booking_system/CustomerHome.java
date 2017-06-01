package com.example.sugaste.futsal_booking_system;

import android.content.Intent;
import android.os.Bundle;
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

//    public Layout contentCustomer = (Layout) findViewById(R.id.body);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnSearchFutsal = (Button) findViewById(R.id.btnSearchFutsal);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
               this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
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
//            super.onBackPressed();
            startActivity(new Intent(this, CustomerHome.class));
            this.finish();
            Toast.makeText(this, "Back Presed.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
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
            getLogOut();
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
        startActivity(new Intent(this, SearchFutsal.class));
        this.finish();

//        contentCustomer.removeAllViews();
//        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
//        View childLayout = inflater.inflate(R.layout.content_search_futsal, (ViewGroup) findViewById(R.id.content_search_futsal));
//        contentCustomer.addView(childLayout);


    }


    public void getBookedFutsal(){
        startActivity(new Intent(this, BookedFutsal.class));
        this.finish();
    }

    public void getNearByFutsal(){

    }

    public void getChallengeRoom(){
        this.finish();
        startActivity(new Intent(this, ChallengeRoom.class));
    }

    public void getWishList(){

    }

    public void getViewOffers(){

    }

    public void settings(){

    }

    public void getLogOut(){
        this.finish();
        startActivity(new Intent(this, LogInActivity.class));
    }
//    end of navigations

}
