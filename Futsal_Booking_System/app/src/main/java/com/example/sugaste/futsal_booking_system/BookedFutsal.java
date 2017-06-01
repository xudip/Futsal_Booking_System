package com.example.sugaste.futsal_booking_system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.xudip.futsalbookingsystem.R;

public class BookedFutsal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_futsal);

        String []listElements = {"1","2", "3","4","5", "6","7","8", "9","10","11", "12"};
        ListAdapter bookedList = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, listElements);
        ListView bookedFutsalList = (ListView) findViewById(R.id.listView);
        bookedFutsalList.setAdapter(bookedList);
    }

    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//            Toast.makeText(this, "Closing Navigation bar.", Toast.LENGTH_SHORT).show();
//
//        }
//        else
    if(this.getClass().toString().equals("CustomerHome")){
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

}
