package com.example.biggy.myapp;

/**
 * Created by Servis on 13.2.2016.
 */
public class OtvorenaIntervencija {

    //private variables
    int _id;
    String _datum_prijave;
    String _vrsta_proizvoda;
    String _serijski_broj;
    String _klijent;
    String _adresa;
    String _mjesto;
    String _kontakt1;
    String _kontakt2;
    String _opis_kvara;
    String _napomena;


    // Empty constructor
    public OtvorenaIntervencija(){

    }

    // constructor
    public OtvorenaIntervencija(int id, String datum_prijave, String vrsta_proizvoda, String serijski_broj, String klijent, String adresa, String mjesto, String kontakt1, String kontakt2,
                                String opis_kvara, String napomena){
        this._id = id;
        this._datum_prijave = datum_prijave;
        this._vrsta_proizvoda = vrsta_proizvoda;
        this._serijski_broj = serijski_broj;
        this._klijent = klijent;
        this._adresa = adresa;
        this._mjesto = mjesto;
        this._kontakt1 = kontakt1;
        this._kontakt2 = kontakt2;
        this._opis_kvara = opis_kvara;
        this._napomena = napomena;
    }

    // constructor
    public OtvorenaIntervencija(String datum_prijave, String vrsta_proizvoda, String serijski_broj, String klijent, String adresa, String mjesto, String kontakt1, String kontakt2,
                                String opis_kvara, String napomena){

        _datum_prijave = datum_prijave;
        _vrsta_proizvoda = vrsta_proizvoda;
        _serijski_broj = serijski_broj;
        _klijent = klijent;
        _adresa = adresa;
        _mjesto = mjesto;
        _kontakt1 = kontakt1;
        _kontakt2 = kontakt2;
        _opis_kvara = opis_kvara;
        _napomena = napomena;
    }




    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // get datum prijave
    public String getDatumPrijave(){
        return this._datum_prijave;
    }

    // set datum prijave
    public void setDatumPrijave(String datum_prijave){
        this._datum_prijave = datum_prijave;
    }

    // get vrsta proizvoda
    public String getVrstaProizvoda(){
        return this._vrsta_proizvoda;
    }

    // set vrsta proizvoda
    public void setVrstaProizvoda(String vrsta_proizvoda){
        this._vrsta_proizvoda = vrsta_proizvoda;
    }

    // get serijski broj
    public String getSerijskiBroj(){
        return this._serijski_broj;
    }

    // set serijski broj
    public void setSerijskiBroj(String serijski_broj){
        this._serijski_broj = serijski_broj;
    }

    // get klijent
    public String getKlijent(){
        return this._klijent;
    }

    // set klijent
    public void setKlijent(String klijent){
        this._klijent = klijent;
    }

    // get adresa
    public String getAdresa(){
        return this._adresa;
    }

    // set adresa
    public void setAdresa(String adresa){
        this._adresa = adresa;
    }

    // get mjesto
    public String getMjesto(){
        return this._mjesto;
    }

    // set mjesto
    public void setMjesto(String mjesto){
        this._mjesto = mjesto;
    }

    // get kontakt1
    public String getKontakt1(){
        return this._kontakt1;
    }

    // set kontakt1
    public void setKontakt1(String kontakt1){
        this._kontakt1 = kontakt1;
    }

    // get kontakt2
    public String getKontakt2(){
        return this._kontakt2;
    }

    // set kontakt2
    public void setKontakt2(String kontakt2){
        this._kontakt2 = kontakt2;
    }

    // get opis kvara
    public String getOpisKvara(){
        return this._opis_kvara;
    }

    // set opis kvara
    public void setOpisKvara(String opis_kvara){
        this._opis_kvara = opis_kvara;
    }

    // get napomena
    public String getNapomena(){
        return this._napomena;
    }

    // set napomena
    public void setNapomena(String napomena){
        this._napomena = napomena;
    }




    public String toString() {
        return this._id + this._datum_prijave + this._vrsta_proizvoda + this._serijski_broj + this._klijent + this._adresa +
                this._mjesto + this._kontakt1 + this._kontakt2 + this._opis_kvara + this._napomena;

    }


}
