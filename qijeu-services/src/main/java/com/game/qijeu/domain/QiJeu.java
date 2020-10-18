package com.game.qijeu.domain;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class QiJeu extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5924719904474298610L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qijeu_generator")
	@SequenceGenerator(name="qijeu_generator", sequenceName = "seq_id_qijeu", allocationSize=50)	
	private Long id;
	
	
	@ManyToOne
	private Saison saison;
	
	private Date dateQiJeu;
	

	@OneToMany
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

	public Saison getSaison() {
		return saison;
	}

	public void setSaison(Saison saison) {
		this.saison = saison;
	}

}
