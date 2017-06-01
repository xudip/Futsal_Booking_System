package com.example.sugaste.futsal_booking_system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xudip.futsalbookingsystem.R;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void actionLogIn(View v){
        this.finish();
        startActivity(new Intent(this, CustomerHome.class));
    }

    public void actionQuit(View v1){
        this.finish();
        Toast.makeText(this, "Futsal Booking System Exited.",Toast.LENGTH_SHORT).show();
    }
    

}
