package com.game.qijeu.domain;

import java.util.Date;
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

import com.game.qijeu.dto.CompetitionDto;

@Entity
public class Competition extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "competition_generator")
	@SequenceGenerator(name = "competition_generator", sequenceName = "seq_id_competition", allocationSize = 1)
	private Long id;

	@Column(nullable = false, length = 50)
	private String nom;

	private Date dateDebut;

	private Date dateFin;

	private Date dateMaj;

	@ManyToOne()
	@JoinColumn(foreignKey = @ForeignKey(name = "client_id_fkey"))
	private Client client;

	@OneToMany(mappedBy = "competition")
	private List<QiJeu> qiJeux;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Date getDateMaj() {
		return dateMaj;
	}

	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}

	public List<QiJeu> getQiJeux() {
		return qiJeux;
	}

	public void setQiJeux(List<QiJeu> qiJeux) {
		this.qiJeux = qiJeux;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Competition() {
	}

	public Competition(CompetitionDto competitionDto) {
		this.id = competitionDto.getId();
		this.nom = competitionDto.getNom();
		this.dateDebut = competitionDto.getDateDebut();
		this.dateFin = competitionDto.getDateFin();
	}

	public Competition(String nom, Date dateDebut, Date dateFin, Client client) {
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.client = client;
	}
}
