package com.jorgearreola.fragments;


public class Amigo
{
    private String nombre;
    private String twitter;
    private String telefono;

    public Amigo(String nombre, String twitter, String telefono){
        this.nombre = nombre;
        this.twitter = twitter;
        this.telefono = telefono;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTwitter(){
        return twitter;
    }

    public String getTelefono(){
        return telefono;
    }
}
