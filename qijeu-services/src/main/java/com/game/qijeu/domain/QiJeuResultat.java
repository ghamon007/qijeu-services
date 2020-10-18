package com.game.qijeu.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

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
	@SequenceGenerator(name="qijeu_resultat_generator", sequenceName = "seq_id_qijeu_resultat", allocationSize=50)	
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

	

}
