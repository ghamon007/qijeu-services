package com.game.qijeu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.game.qijeu.dto.UtilisateurDto;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "login" }, name = "login_ukey") })
public class Utilisateur extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8246929148276493393L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utilisateur_generator")
	@SequenceGenerator(name = "utilisateur_generator", sequenceName = "seq_id_utilisateur", allocationSize = 50)
	private Long id;

	@Column(nullable = false)
	private String login;

	@Column(nullable = false)
	private String password;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "profil_id_fkey"))
	private Parametre profil;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "statut_id_fkey"))
	private Parametre statut;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "client_id_fkey"))
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
