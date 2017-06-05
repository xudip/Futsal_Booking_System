package com.example.sugaste.futsal_booking_system;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.xudip.futsalbookingsystem.R;

public class ChallengeRoom extends Fragment {

    private Spinner spinnerChooseAFutsal, spinnertimeFrom, spinnerTimeFromAmPm, spinnerTimeTo, spinnerTimeToAmPm;
    private Button btnListOfChallenges, btnCreateChallenge, btnCancel;
    private EditText txtDescription;
    private ListView listOfChallenges;

    String futsalName, timeFromData, timeToData, descriptionData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View view = inflater.inflate(R.layout.content_challenge_room, container, false);

        spinnerChooseAFutsal = (Spinner) view.findViewById(R.id.spinnerFutsalName);
        spinnertimeFrom = (Spinner) view.findViewById(R.id.spinnerFrom);
        spinnerTimeFromAmPm = (Spinner) view.findViewById(R.id.spinnerAmPmFrom);
        spinnerTimeTo = (Spinner) view.findViewById(R.id.spinnerTo);
        spinnerTimeToAmPm = (Spinner) view.findViewById(R.id.spinnerAmPmTo);

        btnListOfChallenges = (Button) view.findViewById(R.id.btnListChallenges);
        btnCreateChallenge = (Button) view.findViewById(R.id.btnCreateChallenge);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);

        listOfChallenges = (ListView) view.findViewById(R.id.list_of_challenges);

        btnListOfChallenges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getListOfChallenges();
            }
        });

        btnCreateChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCreateChallengeDailog();
            }
        });

        return view;
    }

    private void getCreateChallengeDailog() {
        Toast.makeText(getContext(), "Show dialog for creating challenges", Toast.LENGTH_SHORT).show();
    }

    private void getListOfChallenges() {
        Toast.makeText(getContext(), "Show list from database", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Challenge Room");
    }
}
