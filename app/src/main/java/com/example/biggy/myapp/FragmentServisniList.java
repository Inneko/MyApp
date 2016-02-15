package com.example.biggy.myapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Biggy on 08.02.2016.
 */
public class FragmentServisniList extends Fragment implements View.OnClickListener {



    public FragmentServisniList() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_servisni_list, container, false);




        Button btn = (Button) rootView.findViewById(R.id.btnsacuvajservisnilist);
        btn.setOnClickListener(this);

        // Inflate the layout for this fragment
        return rootView;







    }

    @Override
    public void onStart(){
        super.onStart();
        //postavljanje datuma u edittext datum servisa
        EditText datumset = (EditText) getActivity().findViewById(R.id.etDatumServisa);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String formattedDate = df.format(c.getTime());
        datumset.setText(formattedDate);

        //ubacivanje stavki u spinner za kvar podliježe garanciji
        Spinner spinnerGarancija = (Spinner) getActivity().findViewById(R.id.spinnerGarancija);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.spinnerDaNe, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGarancija.setAdapter(adapter);

        //ubacivanje stavki u spinner za način plaćanja
        Spinner spinnerNacinPlacanja = (Spinner) getActivity().findViewById(R.id.spinnerNacinPlacanja);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.spinnerNacinPlacanja, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNacinPlacanja.setAdapter(adapter2);

        //ubacivanje stavki u spinner za status plaćanja
        Spinner spinnerStatusPlacanja = (Spinner) getActivity().findViewById(R.id.spinnerStatusPlacanja);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.spinnerDaNe, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatusPlacanja.setAdapter(adapter3);



        //definisanje i postavljanje izgleda spinnera
        ArrayAdapter adapterIzgledSpinnera = ArrayAdapter.createFromResource(getActivity(), R.array.spinnerDaNe, R.layout.spinner_item);
        adapterIzgledSpinnera.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerGarancija.setAdapter(adapterIzgledSpinnera);
        spinnerNacinPlacanja.setAdapter(adapterIzgledSpinnera);
        spinnerStatusPlacanja.setAdapter(adapterIzgledSpinnera);







    }

    @Override
    public void onResume(){
        super.onResume();
    }






    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnsacuvajservisnilist:


                DatabaseHandler db = new DatabaseHandler(getActivity());


                EditText etdatumservisa = (EditText) getActivity().findViewById(R.id.etDatumServisa);
                EditText etserviser = (EditText) getActivity().findViewById(R.id.etServiser);
                EditText etvrstaproizvoda = (EditText) getActivity().findViewById(R.id.etVrstaProizvoda);
                EditText etserijskibroj = (EditText) getActivity().findViewById(R.id.etSerijskiBroj);
                EditText etdatumkupovine = (EditText) getActivity().findViewById(R.id.etDatumKupovine);
                EditText etdatumistekagarancije = (EditText) getActivity().findViewById(R.id.etDatumIstekaGarancije);
                EditText etklijent = (EditText) getActivity().findViewById(R.id.etKupac);
                EditText etadresa = (EditText) getActivity().findViewById(R.id.etAdresa);
                EditText etmjesto = (EditText) getActivity().findViewById(R.id.etMjesto);
                EditText etkontakt1 = (EditText) getActivity().findViewById(R.id.etKontakt1);
                EditText etkontakt2 = (EditText) getActivity().findViewById(R.id.etKontakt2);
                EditText etprimjedbakupca = (EditText) getActivity().findViewById(R.id.etPrimjedbaKupca);
                EditText etopisintervencije = (EditText) getActivity().findViewById(R.id.etOpisIntervencije);
                EditText etnapomena = (EditText) getActivity().findViewById(R.id.etNapomena);
                Spinner spinnerGarancija = (Spinner) getActivity().findViewById(R.id.spinnerGarancija);
                EditText ettroskovidijelova = (EditText) getActivity().findViewById(R.id.etTroskoviDijelova);
                EditText ettroskovirada = (EditText) getActivity().findViewById(R.id.etTroskoviRada);
                EditText etputnitroskovi = (EditText) getActivity().findViewById(R.id.etPutniTroskovi);
                EditText etukupnitroskovi = (EditText) getActivity().findViewById(R.id.etUkupniTroskovi);
                Spinner spinnerNacinPlacanja = (Spinner) getActivity().findViewById(R.id.spinnerNacinPlacanja);
                Spinner spinnerStatusPlacanja = (Spinner) getActivity().findViewById(R.id.spinnerStatusPlacanja);
                EditText etradservisera = (EditText) getActivity().findViewById(R.id.etRadServisera);
                EditText etputservisera = (EditText) getActivity().findViewById(R.id.etPutServisera);


                //uzimanje stringova
                String datum_servisa = etdatumservisa.getText().toString();
                String serviser = etserviser.getText().toString();
                String serijski_broj = etserijskibroj.getText().toString();
                String vrsta = etvrstaproizvoda.getText().toString();
                String datum_kupovine = etdatumkupovine.getText().toString();
                String datum_isteka_garancije = etdatumistekagarancije.getText().toString();
                String klijent = etklijent.getText().toString();
                String adresa = etadresa.getText().toString();
                String mjesto = etmjesto.getText().toString();
                String kontakt1 = etkontakt1.getText().toString();
                String kontakt2 = etkontakt2.getText().toString();
                String primjedba_kupca = etprimjedbakupca.getText().toString();
                String opis_intervencije = etopisintervencije.getText().toString();
                String napomena = etnapomena.getText().toString();
                String kvar_podlijeze_garanciji = spinnerGarancija.getSelectedItem().toString();
                String troskovi_dijelova = ettroskovidijelova.getText().toString();
                String troskovi_rada = ettroskovirada.getText().toString();
                String putni_troskovi = etputnitroskovi.getText().toString();
                String ukupni_troskovi = etukupnitroskovi.getText().toString();
                String nacin_placanja = spinnerNacinPlacanja.getSelectedItem().toString();
                String status_placanja = spinnerStatusPlacanja.getSelectedItem().toString();
                String rad_servisera = etradservisera.getText().toString();
                String put_servisera = etputservisera.getText().toString();


                db.dodajSL(datum_servisa, serviser, serijski_broj, vrsta, datum_kupovine, datum_isteka_garancije, klijent, adresa, mjesto, kontakt1, kontakt2, primjedba_kupca, opis_intervencije, napomena,
                        kvar_podlijeze_garanciji, troskovi_dijelova, troskovi_rada, putni_troskovi, ukupni_troskovi, nacin_placanja, status_placanja, rad_servisera, put_servisera);


                etdatumservisa.setText("");
                etserviser.setText("");
                etvrstaproizvoda.setText("");
                etserijskibroj.setText("");
                etdatumkupovine.setText("");
                etdatumistekagarancije.setText("");
                etklijent.setText("");
                etadresa.setText("");
                etmjesto.setText("");
                etkontakt1.setText("");
                etkontakt2.setText("");
                etprimjedbakupca.setText("");
                etopisintervencije.setText("");
                etnapomena.setText("");
                ettroskovidijelova.setText("");
                ettroskovirada.setText("");
                etputnitroskovi.setText("");
                etukupnitroskovi.setText("");
                etradservisera.setText("");
                etputservisera.setText("");


                Toast.makeText(getActivity(), "Uspješno ste unijeli servisni list", Toast.LENGTH_LONG).show();

                break;

        }
    }

}
