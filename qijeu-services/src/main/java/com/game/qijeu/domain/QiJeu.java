package com.game.qijeu.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.game.qijeu.dto.QiJeuDto;

@Entity
public class QiJeu extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5924719904474298610L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qijeu_generator")
	@SequenceGenerator(name = "qijeu_generator", sequenceName = "seq_id_qijeu", allocationSize = 50)
	private Long id;

	private String nom;

	private Date dateQiJeu;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "competition_id_fkey"))
	private Competition competition;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "questionnaire_id_fkey"))
	private Questionnaire questionnaire;

	@OneToMany(mappedBy = "qijeu")
	private List<QiJeuResultat> resultats;

	public Date getDateQiJeu() {
		return dateQiJeu;
	}

	public void setDateQiJeu(Date dateQiJeu) {
		this.dateQiJeu = dateQiJeu;
	}

	public List<QiJeuResultat> getResultats() {
		return resultats;
	}

	public void setResultats(List<QiJeuResultat> resultats) {
		this.resultats = resultats;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition aCompetition) {
		this.competition = aCompetition;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public QiJeu() {
	}

	public QiJeu(QiJeuDto qiJeuDto) {
		this.nom = qiJeuDto.getNom();
		this.dateQiJeu = qiJeuDto.getDateQiJeu();
		this.id = qiJeuDto.getId();
	}

	public QiJeu(String nom, Date dateQiJeu, Competition competition) {
		this.nom = nom;
		this.dateQiJeu = dateQiJeu;
		this.competition = competition;
	}

}
