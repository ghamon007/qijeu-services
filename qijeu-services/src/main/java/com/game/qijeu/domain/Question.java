package com.game.qijeu.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity

public class Question extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_generator")
	@SequenceGenerator(name = "question_generator", sequenceName = "seq_id_question", allocationSize = 50)
	private Long id;

	private String libelle;

	private String reponse;

	private String metadonnees;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "statut_id_fkey"))
	private Parametre statut;

	@Version
	private int version;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "theme_id_fkey"))
	private Theme theme;

	@ManyToMany
	@JoinTable(name = "question_support", joinColumns = { @JoinColumn(name = "question_id") }, inverseJoinColumns = {
			@JoinColumn(name = "support_id") }, uniqueConstraints = {
					@UniqueConstraint(name = "question_support_ukey", columnNames = { "question_id",
							"support_id" }) }, foreignKey = @ForeignKey(name = "question_id_fkey"), inverseForeignKey = @ForeignKey(name = "support_id_fkey"))
	private List<Support> supports;

	@ManyToMany
	@JoinTable(name = "questionnaire_question", joinColumns = {
			@JoinColumn(name = "questionnaire_id") }, inverseJoinColumns = {
					@JoinColumn(name = "question_id") }, uniqueConstraints = {
							@UniqueConstraint(name = "questionnaire_question_ukey", columnNames = { "questionnaire_id",
									"question_id" }) }, foreignKey = @ForeignKey(name = "questionnaire_id_fkey"), inverseForeignKey = @ForeignKey(name = "question_id_fkey"))
	private List<Questionnaire> questionnaires;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public String getMetadonnees() {
		return metadonnees;
	}

	public void setMetadonnees(String metadonnees) {
		this.metadonnees = metadonnees;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public List<Support> getSupports() {
		return supports;
	}

	public void setSupports(List<Support> supports) {
		this.supports = supports;
	}

	public Parametre getStatut() {
		return statut;
	}

	public void setStatut(Parametre statut) {
		this.statut = statut;
	}

	public List<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(List<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}
}
