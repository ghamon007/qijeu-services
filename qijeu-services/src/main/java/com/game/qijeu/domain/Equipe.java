package com.game.qijeu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.game.qijeu.dto.EquipeDto;

@Entity
public class Equipe extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipe_generator")
	@SequenceGenerator(name = "equipe_generator", sequenceName = "seq_id_equipe", allocationSize = 50)
	private Long id;

	@Column(nullable = false, length = 50)
	private String nom;

	private String email1;

	private String email2;

	private String telephone1;

	private String telephone2;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "client_id_fkey"))
	private Client client;

	@OneToMany(mappedBy = "equipe")
	private List<QiJeuResultat> qiJeuResultats;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<QiJeuResultat> getQiJeuResultats() {
		return qiJeuResultats;
	}

	public void setQiJeuResultats(List<QiJeuResultat> qiJeuResultats) {
		this.qiJeuResultats = qiJeuResultats;
	}

	public Equipe() {
	}

	public Equipe(String nom, String email1, Client client) {
		this.nom = nom;
		this.email1 = email1;
		this.client = client;
	}

	public Equipe(EquipeDto equipeDto) {
		this.id = equipeDto.getId();
		this.nom = equipeDto.getNom();
		this.email1 = equipeDto.getEmail1();
		this.email2 = equipeDto.getEmail2();
		this.telephone1 = equipeDto.getTelephone1();
		this.telephone2 = equipeDto.getTelephone2();
	}

}
