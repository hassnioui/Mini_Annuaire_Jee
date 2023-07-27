package com.ens.annuaire.bean;

public class Etudiant {
	private int CNE;
    private String nom;
    private String prenom;
    private String filiere;
    private String departement;
    private String telephone;
    
	public Etudiant(int cNE, String nom, String prenom, String filiere, String departement, String telephone) {
		super();
		CNE = cNE;
		this.nom = nom;
		this.prenom = prenom;
		this.filiere = filiere;
		this.departement = departement;
		this.telephone = telephone;
	}
	public Etudiant(String nom, String prenom, String filiere, String departement, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.filiere = filiere;
		this.departement = departement;
		this.telephone = telephone;
	}
	public int getCNE() {
		return CNE;
	}
	public void setCNE(int cNE) {
		CNE = cNE;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
