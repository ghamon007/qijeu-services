package com.game.qijeu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Theme extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "theme_generator")
	@SequenceGenerator(name = "theme_generator", sequenceName = "seq_id_theme", allocationSize = 1)
	private Long id;

	@Column(nullable = false, length = 32)
	private String libelle;

	@Column(length = 255)
	private String description;

	@OneToMany(mappedBy = "theme")
	private List<Question> questions;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String titre) {
		this.libelle = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
