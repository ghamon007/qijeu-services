package com.game.qijeu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Utilisateur extends BaseEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8246929148276493393L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utilisateur_generator")
	@SequenceGenerator(name="utilisateur_generator", sequenceName = "seq_id_utilisateur", allocationSize=50)	
	private Long id;
	
	@Column(nullable=false, unique = true)
	private String login;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false, unique = true)
	private String email1;

	private String email2;

	private String telephone1;

	private String telephone2;
	
	@ManyToOne
	private Parametre profil;

	@ManyToOne
	private Parametre statut;

	@ManyToOne
	private Client client;
	
	public Utilisateur(String login, String password, String email, Parametre profil, Parametre statut) {
		this.login = login;
		this.password = password;
		this.email1 = email;
		this.profil = profil;
		this.statut = statut;
	}

	public Utilisateur() {
	}

	public Utilisateur(String login, String password, Parametre statut) {
		this.login = login;
		this.password = password;
		this.statut = statut;
	}	
	public Utilisateur(String login, String password, String email1, String email2, String telephone1, String telephone2) {
		this.login = login;
		this.password = password;
		this.email1 = email1;
		this.email2 = email2;
		this.telephone1 = telephone1;
		this.telephone2 = telephone2;
	}		
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Parametre getProfil() {
		return profil;
	}
	public void setProfil(Parametre profil) {
		this.profil = profil;
	}

	public Parametre getStatut() {
		return statut;
	}

	public void setStatut(Parametre statut) {
		this.statut = statut;
	}

	public Long getId() {
		return id;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}


}
