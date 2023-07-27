package com.ens.annuaire.bean;

public class Departement {
	
	private int id;
    private String nom;
    
    
    
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
	public Departement(String nom) {
		super();
		this.nom = nom;
	}
	public Departement(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

}
