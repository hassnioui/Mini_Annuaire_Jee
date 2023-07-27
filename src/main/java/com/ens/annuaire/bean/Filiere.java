package com.ens.annuaire.bean;

public class Filiere {
    private int id;
    private String nom;
    private int departementId;

    public Filiere(String nom, int departementId) {
        this.nom = nom;
        this.departementId = departementId;
    }

    public Filiere(int id, String nom, int departementId) {
        this.id = id;
        this.nom = nom;
        this.departementId = departementId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDepartementId() {
        return departementId;
    }

    public void setDepartementId(int departementId) {
        this.departementId = departementId;
    }
}
