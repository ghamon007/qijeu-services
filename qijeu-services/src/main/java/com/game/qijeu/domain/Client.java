package com.game.qijeu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Client extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8532899483744083103L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_generator")
	@SequenceGenerator(name = "client_generator", sequenceName = "seq_id_client", allocationSize = 50)
	private Long id;

	@Column(nullable = false, length = 50)
	private String nom;

	@Column(length = 100)
	private String adresse;

	private String codePostal;

	private String commune;

	private String pays;

	@OneToMany(mappedBy = "client")
	private List<Contact> contacts;

	@OneToMany
	private List<QiJeu> qiJeux;

	@OneToMany
	private List<Equipe> equipes;

	public Client() {
	}

	public Client(String nom) {
		this.nom = nom;
	}

	public Client(String nom, String adresse, String codePostal, String commune, String pays) {
		this.nom = nom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.commune = commune;
		this.pays = pays;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public List<QiJeu> getQiJeux() {
		return qiJeux;
	}

	public void setQiJeux(List<QiJeu> qiJeux) {
		this.qiJeux = qiJeux;
	}

	public Long getId() {
		return id;
	}

}
