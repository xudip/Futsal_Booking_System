package com.example.sugaste.futsal_booking_system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.xudip.futsalbookingsystem.R;

public class ChallengeRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_challenge_room);
    }

    @Override
    public void onBackPressed() {
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
