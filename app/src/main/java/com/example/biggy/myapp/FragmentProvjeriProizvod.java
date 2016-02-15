package com.example.biggy.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Biggy on 08.02.2016.
 */
public class FragmentProvjeriProizvod extends Fragment implements View.OnClickListener {

    public FragmentProvjeriProizvod() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_provjeri_proizvod, container, false);


        Button button =(Button)rootView.findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent dbmanager = new Intent(getActivity(),AndroidDatabaseManager.class);
                startActivity(dbmanager);
            }
        });



        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onClick(View v) {



    }
}
