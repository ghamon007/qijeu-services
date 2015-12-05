package com.game.qijeu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Theme extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false,length=32)
	private String libelle;
	
	@Column(length=255)
	private String description;
	

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String titre) {
		this.libelle = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
