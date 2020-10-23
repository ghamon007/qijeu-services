package com.game.qijeu.domain;

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
	private String email;
	
	@ManyToOne
	private Parametre profil;

	@ManyToOne
	private Parametre statut;
	
	@OneToMany
	private List<Contact> constacts;
	
	public Utilisateur(String login, String password, String email, Parametre profil, Parametre statut) {
		this.login = login;
		this.password = password;
		this.email = email;
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
	public Utilisateur(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Parametre getProfil() {
		return profil;
	}
	public void setProfil(Parametre profil) {
		this.profil = profil;
	}
	public List<Contact> getConstacts() {
		return constacts;
	}
	public void setConstacts(List<Contact> constacts) {
		this.constacts = constacts;
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


}
