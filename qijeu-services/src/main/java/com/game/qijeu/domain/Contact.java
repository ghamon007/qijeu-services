package com.game.qijeu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Contact extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false,columnDefinition = "ENUM('BUREAU', 'DOMICILE', 'MOBILE_PRO','MOBILE_PERSO','FAX')")
	private TYPE_CONTACT type;
	
	@Column(nullable=false)
	private String valeur;
	
	@ManyToOne
	private Client client;
	
	enum TYPE_CONTACT {
		BUREAU,
		DOMICILE,
		MOBILE_PRO,
		MOBILE_PERSO,
		FAX
	}



	public TYPE_CONTACT getType() {
		return type;
	}



	public void setType(TYPE_CONTACT type) {
		this.type = type;
	}



	public String getValeur() {
		return valeur;
	}



	public void setValeur(String valeur) {
		this.valeur = valeur;
	}



	

}
