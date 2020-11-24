package com.game.qijeu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Support extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "support_generator")
	@SequenceGenerator(name = "support_generator", sequenceName = "seq_id_support", allocationSize = 50)
	private Long id;

	@Column(nullable = false)
	private String cheminFichier;

	private String metaDonnees;

	private String description;

	@ManyToMany(mappedBy = "supports")
	private List<Question> questions;

	public String getCheminFichier() {
		return cheminFichier;
	}

	public void setCheminFichier(String cheminFichier) {
		this.cheminFichier = cheminFichier;
	}

	public String getMetaDonnees() {
		return metaDonnees;
	}

	public void setMetaDonnees(String metaDonnees) {
		this.metaDonnees = metaDonnees;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
