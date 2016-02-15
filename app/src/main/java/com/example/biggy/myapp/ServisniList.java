package com.example.biggy.myapp;

/**
 * Created by Servis on 9.2.2016.
 */
public class ServisniList {

    //private variables
    int _id;
    String _datum_servisa;
    String _serviser;


    // Empty constructor
    public ServisniList(){

    }

    // constructor
    public ServisniList(int id, String datum_prijave, String vrsta_proizvoda){
        this._id = id;
        this._datum_servisa = datum_prijave;
        this._serviser = vrsta_proizvoda;
    }

    // constructor
    public ServisniList(String datum_servisa, String serviser){
        _datum_servisa = datum_servisa;
        _serviser = serviser;
    }


    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // get datum servisa
    public String getDatumServisa(){
        return this._datum_servisa;
    }

    // set datum servisa
    public void setDatumServisa(String datum_servisa){
        this._datum_servisa = datum_servisa;
    }

    // get serviser
    public String getServiser(){
        return this._serviser;
    }

    // set serviser
    public void setServiser(String serviser){
        this._serviser = serviser;
    }

public String toString() {
    return _datum_servisa;

}




}
