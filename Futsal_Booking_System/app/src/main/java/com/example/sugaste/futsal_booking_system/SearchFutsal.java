package com.example.sugaste.futsal_booking_system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.xudip.futsalbookingsystem.R;

public class SearchFutsal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_search_futsal);

        Spinner spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        Spinner spinnerTo = (Spinner) findViewById(R.id.spinnerTo);
        Spinner spinnerAmPmFrom = (Spinner) findViewById(R.id.spinnerAmPmFrom);
        Spinner spinnerAmPmTo = (Spinner) findViewById(R.id.spinnerAmPmTo);

        spinnerFrom.setAdapter(getspinnerFrom());
        spinnerAmPmFrom.setAdapter(getspinnerAmPm());

        spinnerTo.setAdapter(getspinnerTo());
        spinnerAmPmTo.setAdapter(getspinnerAmPm());
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


//    get the value for startup.

    public ArrayAdapter<Integer> getspinnerFrom(){
        Integer from[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        ArrayAdapter <Integer> adapterSpinnerFrom = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, from );
        return (adapterSpinnerFrom);
    }

    public ArrayAdapter<Integer> getspinnerTo(){
        Integer to[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        ArrayAdapter <Integer> adapterSpinnerTo = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, to );
        return (adapterSpinnerTo);
    }

    public ArrayAdapter<String> getspinnerAmPm(){
        String ampm[] = {"AM", "PM"};
        ArrayAdapter<String> adapterAmPm = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, ampm);
        return(adapterAmPm);
    }
//    end of value of startup.
}
