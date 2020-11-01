package com.game.qijeu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.game.qijeu.dto.UtilisateurDto;

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
	
	@ManyToOne
	private Parametre profil;

	@ManyToOne
	private Parametre statut;

	@ManyToOne
	private Client client;
	
	public Utilisateur(String login, String password, Parametre profil, Parametre statut) {
		this.login = login;
		this.password = password;
		this.profil = profil;
		this.statut = statut;
	}

	public Utilisateur() {
	}

	
	public Utilisateur(UtilisateurDto utilisateurDto) {
		this.id = utilisateurDto.getId();
		this.login = utilisateurDto.getLogin();
		this.password = utilisateurDto.getPassword();
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


	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


}
