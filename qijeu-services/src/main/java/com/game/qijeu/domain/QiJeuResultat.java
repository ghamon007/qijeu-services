package com.game.qijeu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.game.qijeu.dto.QiJeuResultatDto;

@Entity
public class QiJeuResultat extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4805015844067238065L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qijeu_resultat_generator")
	@SequenceGenerator(name = "qijeu_resultat_generator", sequenceName = "seq_id_qijeu_resultat", allocationSize = 50)
	private Long id;

	@ManyToOne
	private QiJeu qijeu;

	private Equipe equipe;

	private Integer points;

	public QiJeu getQijeu() {
		return qijeu;
	}

	public void setQijeu(QiJeu qijeu) {
		this.qijeu = qijeu;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public QiJeuResultat() {
	}

	public QiJeuResultat(QiJeuResultatDto qiJeuResultatDto) {
		this.id = qiJeuResultatDto.getId();
		this.points = qiJeuResultatDto.getPoints();
	}

	public QiJeuResultat(QiJeu qiJeu, Equipe equipe, Integer points) {
		this.equipe = equipe;
		this.qijeu = qiJeu;
		this.points = points;
	}

}
