package com.game.qijeu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.game.qijeu.dto.QuestionnaireDto;

@Entity
public class Questionnaire extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questionnaire_generator")
	@SequenceGenerator(name = "questionnaire_generator", sequenceName = "seq_id_questionnaire", allocationSize = 1)
	private Long id;

	@Column(nullable = false)
	private String nom;

	private String description;

	@Column
	@Lob
	private byte[] fichier;

	@ManyToMany(mappedBy = "questionnaires")
	private List<Question> questions;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public byte[] getFichier() {
		return fichier;
	}

	public void setFichier(byte[] fichier) {
		this.fichier = fichier;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Questionnaire(QuestionnaireDto questionnaireDto) {
		this.id = questionnaireDto.getId();
		this.nom = questionnaireDto.getNom();
		this.description = questionnaireDto.getDescription();
		/**
		 * try { this.fichier = questionnaireDto.getFichier().getBytes(); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 **/
	}

	public Questionnaire() {
	}

}
