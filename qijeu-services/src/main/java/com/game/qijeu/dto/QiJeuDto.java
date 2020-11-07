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

    private String nomQuestionnaire;

    private Long idCompetition;

    private String nomCompetition;

    private String nomClient;

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

    public Date getDateQiJeu() {
        return dateQiJeu;
    }

    public void setDateQiJeu(Date dateQiJeu) {
        this.dateQiJeu = dateQiJeu;
    }

    public String getNomQuestionnaire() {
        return nomQuestionnaire;
    }

    public void setNomQuestionnaire(String nomQuestionnaire) {
        this.nomQuestionnaire = nomQuestionnaire;
    }

    public String getNomCompetition() {
        return nomCompetition;
    }

    public void setNomCompetition(String nomCompetition) {
        this.nomCompetition = nomCompetition;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public QiJeuDto(QiJeu qiJeu) {
        this.id = qiJeu.getId();
        this.nom = qiJeu.getNom();
        this.dateQiJeu = qiJeu.getDateQiJeu();
        this.dateCreation = qiJeu.getDateCreation();
        this.idCompetition = (qiJeu.getCompetition() != null ? qiJeu.getCompetition().getId() : null);
        this.idQuestionnaire = (qiJeu.getQuestionnaire() != null ? qiJeu.getQuestionnaire().getId() : null);
        this.nomCompetition = (qiJeu.getCompetition() != null ? qiJeu.getCompetition().getNom() : null);
        this.nomQuestionnaire = (qiJeu.getQuestionnaire() != null ? qiJeu.getQuestionnaire().getNom() : null);
        this.nomClient = (qiJeu.getCompetition()!=null && qiJeu.getCompetition().getClient() != null ? qiJeu.getCompetition().getClient().getNom() : null);
    }

    public QiJeuDto() {

    }

}
