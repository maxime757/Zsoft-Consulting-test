package com.maximevienne.demo;


public class Escalier {
    private int Possibilite;
    private final String Nombre_de_marche;

    public Escalier(int p,String content){
        this.Possibilite = p;
        this.Nombre_de_marche = content;
    }
    public int getPossibilite(){
        return Possibilite;
    }
    public String getNombre_de_marche(){
        return Nombre_de_marche;
    }
}