package com.game.qijeu.dto;

import java.io.Serializable;
import java.util.Date;

import com.game.qijeu.domain.QiJeu;

public class QiJeuDto implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -407764962223856216L;

    private Long id;

    private String nom;
    
    private Date dateQiJeu;

    private Long idQuestionnaire;

    private Long idCompetition;

    private Date dateCreation;

    private Date dateModification;

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


    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

	public Long getIdQuestionnaire() {
		return idQuestionnaire;
	}

	public void setIdQuestionnaire(Long idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}

	public Long getIdCompetition() {
		return idCompetition;
	}

	public void setIdCompetition(Long idCompetition) {
		this.idCompetition = idCompetition;
	}

	public QiJeuDto(QiJeu qiJeu) {
        this.id  =qiJeu.getId();
        this.nom = qiJeu.getNom();
        this.dateQiJeu = qiJeu.getDateQiJeu();
        this.idCompetition = (qiJeu.getCompetition()!=null?qiJeu.getCompetition().getId():null);
        this.idQuestionnaire = (qiJeu.getQuestionnaire()!=null?qiJeu.getQuestionnaire().getId():null);
    }
    
    public QiJeuDto(){

    }

	public Date getDateQiJeu() {
		return dateQiJeu;
	}

	public void setDateQiJeu(Date dateQiJeu) {
		this.dateQiJeu = dateQiJeu;
	}

     
}
