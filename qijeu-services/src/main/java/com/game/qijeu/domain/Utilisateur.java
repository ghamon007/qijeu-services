package com.game.qijeu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;

@Entity
public class Utilisateur extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String login;
	
	@Column(nullable=false)
	private String password;
	
	@Email
	@Column(nullable=false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false,columnDefinition = "ENUM('ADMIN', 'USER')")
	private PROFIL_UTILISATEUR profil;
	

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
	public PROFIL_UTILISATEUR getProfil() {
		return profil;
	}
	public void setProfil(PROFIL_UTILISATEUR profil) {
		this.profil = profil;
	}

	enum PROFIL_UTILISATEUR {
		ADMIN,
		USER
	}
}
