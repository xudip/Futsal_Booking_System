package com.example.sugaste.futsal_booking_system;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.xudip.futsalbookingsystem.R;

public class SearchFutsal extends Fragment {

    private EditText txtFutsalName, txtFutsalAddress;
    private Spinner spinnerFrom, spinnerTo, spinnerFromAmPm, spinnerToAmPm;
    private Button btnSearch;
    private ListView listOfFutsal;
    private String futsalName,
        futsalAddress,
        timeFrom,
        timeTo;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View view = inflater.inflate(R.layout.content_search_futsal, container, false);

        txtFutsalName = (EditText) view.findViewById(R.id.txt_name_of_futsal);
        txtFutsalAddress = (EditText) view.findViewById(R.id.txt_address_of_futsal);
        spinnerFrom = (Spinner) view.findViewById(R.id.spinnerFrom);
        spinnerTo = (Spinner) view.findViewById(R.id.spinnerTo);
        spinnerFromAmPm = (Spinner) view.findViewById(R.id.spinnerAmPmFrom);
        spinnerToAmPm = (Spinner) view.findViewById(R.id.spinnerAmPmTo);
        getTimeSpinnerData();

        btnSearch = (Button) view.findViewById(R.id.btnSearch);

        listOfFutsal = (ListView) view.findViewById(R.id.list_of_futsal);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getListOfFutsal();
                setSearchData();
                Toast.makeText(getContext(), "Time FROM :" + spinnerFrom.getSelectedItem().toString() +
                        " " + spinnerFromAmPm.getSelectedItem().toString() + "\n" +
                        " " + spinnerTo.getSelectedItem().toString() + " " + spinnerToAmPm.getSelectedItem().toString()
                        , Toast.LENGTH_SHORT).show();
            }
        });

        listOfFutsal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int x = view.getId();
                String x1 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(),"item clicked = " + x + "\n" + x1, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void getListOfFutsal() {
        String futsalList[] = {"AAAA", "BBBBB", "CCCCCC" };
        ArrayAdapter<String> listItemsAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,futsalList);
        listItemsAdapter.notifyDataSetChanged();
        listOfFutsal.setAdapter(listItemsAdapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Search Futsal");
    }

    public void getTimeSpinnerData() {
        String amPmData[] = {"AM", "PM" };
        ArrayAdapter<String> amPmAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, amPmData);
        spinnerToAmPm.setAdapter(amPmAdapter);
        spinnerFromAmPm.setAdapter(amPmAdapter);

        String time[] = {"1", "2" ,"3","4", "5" ,"6", "7", "8" ,"9","10", "11" ,"12"};
        ArrayAdapter<String> timeAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, time);
        spinnerFrom.setAdapter(timeAdapter);
        spinnerTo.setAdapter(timeAdapter);

    }

    public void setSearchData()
    {
        futsalName = txtFutsalName.getText().toString().trim();
        futsalAddress = txtFutsalAddress.getText().toString().trim();
        timeFrom = spinnerFrom.getSelectedItem().toString() + " " + spinnerFromAmPm.getSelectedItem().toString();
        timeTo = spinnerTo.getSelectedItem().toString() + " " + spinnerToAmPm.getSelectedItem().toString();

        if(!futsalAddress.equals("") && !futsalAddress.equals("")  && !timeFrom.equals("") && !timeTo.equals("")){
            Toast.makeText(getContext(), "Futsal Name: " +futsalName + "\n" +
                            "Futsal Address: " + futsalAddress + "\n" +
                            "Time From: " + timeFrom + "\n" +
                            "Time From: " + timeTo
                    , Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(), "SOMETHING IS MISSING FIND IT AND HIGHLIGHT IT", Toast.LENGTH_SHORT).show();
        }

    }


}
