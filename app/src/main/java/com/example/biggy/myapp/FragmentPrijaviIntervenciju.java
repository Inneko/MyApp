package com.example.biggy.myapp;

import android.content.Intent;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Servis on 13.2.2016.
 */
public class FragmentPrijaviIntervenciju extends Fragment implements View.OnClickListener{

    public FragmentPrijaviIntervenciju() {
        // Required empty public constructor
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_prijavi_intervenciju, container, false);

        Button btn = (Button) rootView.findViewById(R.id.btnPrijaviIntervenciju);
        btn.setOnClickListener(this);



        // Inflate the layout for this fragment
        return rootView;
    }


    @Override
    public void onStart(){
        super.onStart();
        /*//postavljanje datuma u edittext datum servisa
        EditText datumset = (EditText) getActivity().findViewById(R.id.etDatumServisa);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String formattedDate = df.format(c.getTime());
        datumset.setText(formattedDate);*/

        //ubacivanje stavki u spinner vrsta proizvoda
        Spinner spinnerVrstaProizvoda = (Spinner) getActivity().findViewById(R.id.spinnerVrstaProizvoda);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.spinnerVrstaProizvoda, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVrstaProizvoda.setAdapter(adapter);





        //definisanje i postavljanje izgleda spinnera
        ArrayAdapter adapterIzgledSpinnera = ArrayAdapter.createFromResource(getActivity(), R.array.spinnerVrstaProizvoda, R.layout.spinner_item);
        adapterIzgledSpinnera.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerVrstaProizvoda.setAdapter(adapterIzgledSpinnera);



    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnPrijaviIntervenciju:


                DatabaseHandler db = new DatabaseHandler(getActivity());


                EditText etdatumprijave = (EditText) getActivity().findViewById(R.id.etDatumPrijave);
                Spinner spinnerVrstaProizvoda = (Spinner) getActivity().findViewById(R.id.spinnerVrstaProizvoda);
                EditText etserijskibroj = (EditText) getActivity().findViewById(R.id.etSerijskiBroj);
                EditText etklijent = (EditText) getActivity().findViewById(R.id.etKupac);
                EditText etadresa = (EditText) getActivity().findViewById(R.id.etAdresa);
                EditText etmjesto = (EditText) getActivity().findViewById(R.id.etMjesto);
                EditText etkontakt1 = (EditText) getActivity().findViewById(R.id.etKontakt1);
                EditText etkontakt2 = (EditText) getActivity().findViewById(R.id.etKontakt2);
                EditText etopiskvara = (EditText) getActivity().findViewById(R.id.etOpisKvara);
                EditText etnapomena = (EditText) getActivity().findViewById(R.id.etNapomena);


                //uzimanje stringova
                String datum_prijave = etdatumprijave.getText().toString();
                String vrsta_proizvoda = spinnerVrstaProizvoda.getSelectedItem().toString();
                String serijski_broj = etserijskibroj.getText().toString();
                String klijent = etklijent.getText().toString();
                String adresa = etadresa.getText().toString();
                String mjesto = etmjesto.getText().toString();
                String kontakt1 = etkontakt1.getText().toString();
                String kontakt2 = etkontakt2.getText().toString();
                String opis_kvara = etopiskvara.getText().toString();
                String napomena = etnapomena.getText().toString();



                db.prijaviIntervenciju(datum_prijave, vrsta_proizvoda, serijski_broj, klijent, adresa, mjesto, kontakt1, kontakt2, opis_kvara, napomena);


                etdatumprijave.setText("");
                spinnerVrstaProizvoda.setSelection(0);
                etserijskibroj.setText("");
                etklijent.setText("");
                etadresa.setText("");
                etmjesto.setText("");
                etkontakt1.setText("");
                etkontakt2.setText("");
                etopiskvara.setText("");
                etnapomena.setText("");


                Toast.makeText(getActivity(), "Uspješno ste prijavili intervenciju", Toast.LENGTH_LONG).show();

                break;

        }
    }
}
