package com.game.qijeu.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Saison extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "saison_generator")
	@SequenceGenerator(name="saison_generator", sequenceName = "seq_id_saison", allocationSize=50)	
	private Long id;

	@Column(nullable = false, length = 50)
	private String nom;


	private Date dateDebut;

	private Date dateFin;

	private Date dateMaj;

	
	@ManyToOne
	private Client client;


	@OneToMany
	private List<QiJeu> qiJeux;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Date getDateMaj() {
		return dateMaj;
	}

	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}

	public List<QiJeu> getQiJeux() {
		return qiJeux;
	}

	public void setQiJeux(List<QiJeu> qiJeux) {
		this.qiJeux = qiJeux;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}
