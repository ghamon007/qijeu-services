package com.game.qijeu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Question extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String libelle;
	
	private String reponse;
	
	private String metadonnees;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('BROUILLON', 'VALIDE', 'PUBLIE')")
	private STATUT_QUESTION statut;
	
	@Version
	private int version;
	
	@ManyToOne
	private Theme theme;
	
	@ManyToMany
	private List<Support> supports;

	enum STATUT_QUESTION {
		BROUILLON,
		VALIDE,
		PUBLIE
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public String getReponse() {
		return reponse;
	}


	public void setReponse(String reponse) {
		this.reponse = reponse;
	}


	public String getMetadonnees() {
		return metadonnees;
	}


	public void setMetadonnees(String metadonnees) {
		this.metadonnees = metadonnees;
	}


	public STATUT_QUESTION getStatut() {
		return statut;
	}


	public void setStatut(STATUT_QUESTION statut) {
		this.statut = statut;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public Theme getTheme() {
		return theme;
	}


	public void setTheme(Theme theme) {
		this.theme = theme;
	}


	public List<Support> getSupports() {
		return supports;
	}


	public void setSupports(List<Support> supports) {
		this.supports = supports;
	}
}
