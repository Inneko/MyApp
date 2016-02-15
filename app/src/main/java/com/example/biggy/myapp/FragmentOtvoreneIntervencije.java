package com.example.biggy.myapp;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_list_item_1;

/**
 * Created by Biggy on 08.02.2016.
 */
public class FragmentOtvoreneIntervencije extends Fragment {



    public FragmentOtvoreneIntervencije() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_otvorene_intervencije, container, false);



        //izrada liste otvorenih intervencija
        DatabaseHandler dbhandler = new DatabaseHandler(getActivity());
        List<OtvorenaIntervencija> otvoreneintervencije = dbhandler.getSveOtvoreneIntervencije();
        ArrayAdapter<OtvorenaIntervencija> adapter = new ArrayAdapter<OtvorenaIntervencija>(getActivity(), android.R.layout.simple_list_item_1, otvoreneintervencije);
        ListView lv = (ListView) rootView.findViewById(R.id.listView1);
        lv.setAdapter(adapter);



    // Inflate the layout for this fragment
            return rootView;
        }

}
