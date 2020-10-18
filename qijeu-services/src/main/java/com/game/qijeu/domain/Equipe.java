package com.game.qijeu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.Email;

@Entity
public class Equipe extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipe_generator")
	@SequenceGenerator(name="equipe_generator", sequenceName = "seq_id_equipe", allocationSize=50)	
	private Long id;

	@Column(nullable = false, length = 50)
	private String nom;


	@OneToMany(mappedBy = "equipe")
	private List<Contact> contacts;
	
	@ManyToMany
	private List<QiJeu> qiJeus;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}


}
