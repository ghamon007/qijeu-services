package com.game.qijeu.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.game.qijeu.dto.ClientDto;

@Entity
public class Client extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8532899483744083103L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_generator")
	@SequenceGenerator(name = "client_generator", sequenceName = "seq_id_client", allocationSize = 50)
	private Long id;

	@Column(nullable = false, length = 50)
	private String nom;

	@Column(length = 100)
	private String adresse;

	private String codePostal;

	private String commune;

	private String pays;

	private String email1;

	private String email2;

	private String telephone1;

	private String telephone2;

	@OneToMany
	private List<Equipe> equipes;

	@OneToMany
	private List<Competition> competitions;

	public Client() {
	}

	public Client(String nom) {
		this.nom = nom;
	}

	public Client(String nom, String adresse, String codePostal, String commune, String pays) {
		this.nom = nom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.commune = commune;
		this.pays = pays;
	}

	public Client(ClientDto clientDto) {
		this.nom = clientDto.getNom();
		this.adresse = clientDto.getAdresse();
		this.codePostal = clientDto.getCodePostal();
		this.commune = clientDto.getCommune();
		this.pays = clientDto.getPays();
		this.email1 = clientDto.getEmail1();
		this.email2 = clientDto.getEmail2();
		this.telephone1 = clientDto.getTelephone1();
		this.telephone2 = clientDto.getTelephone2();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}


	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
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

	public void setId(Long id) {
		this.id = id;
	}

	public void addCompetition(Competition competition){
		if (competitions == null){
			competitions = new ArrayList<>();
		}
		competitions.add(competition);
	}

	public void deleteCompetition(Competition competition){
		competitions.remove(competition);
	}

	public List<Competition> getCompetitions() {
		return competitions;
	}

	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}

}
