package com.game.qijeu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Parametre extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4439662100231917533L;

	public Parametre() {
	}
	
	public Parametre(String code, String libelle, String type) {
		this.code = code;
		this.libelle = libelle;
		this.type = type;
	}

	public Parametre(String code, String libelle, String description, String type) {
		this.code = code;
		this.libelle = libelle;
		this.description = description;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "param_generator")
	@SequenceGenerator(name="param_generator", sequenceName = "seq_id_param", allocationSize=50)	
	private Long id;

	@Column(nullable=false,length=32,unique = true)
	private String code;

	@Column(nullable=false,length=32)
	private String libelle;
	
	@Column(length=255)
	private String description;

	@Column(nullable=false,length=32)
	private String type;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	
}
