package com.game.qijeu.dto;

import java.io.Serializable;
import java.util.Date;

import com.game.qijeu.domain.QiJeuResultat;

public class QiJeuResultatDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8586411126506102735L;

    private Long id;

    private Long idQiJeu;

    private String nomQiJeu;

    private Long idCompetition;

    private String nomCompetition;

    private Long idClient;

    private String nomClient;

    private Long idEquipe;

    private String nomEquipe;

    private int points;

    private Date dateCreation;

    private Date dateModification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
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

    public QiJeuResultatDto(QiJeuResultat qiJeuResultat) {
        this.id = qiJeuResultat.getId();
        this.idEquipe = qiJeuResultat.getEquipe().getId();
        this.nomEquipe = qiJeuResultat.getEquipe().getNom();
        this.idQiJeu = (qiJeuResultat.getQijeu()!=null?qiJeuResultat.getQijeu().getId():null);
        this.nomQiJeu = (qiJeuResultat.getQijeu()!=null?qiJeuResultat.getQijeu().getNom():null);
        this.idCompetition = (qiJeuResultat.getQijeu()!=null && qiJeuResultat.getQijeu().getCompetition() != null?qiJeuResultat.getQijeu().getCompetition().getId():null);
        this.nomCompetition = (qiJeuResultat.getQijeu()!=null && qiJeuResultat.getQijeu().getCompetition() != null?qiJeuResultat.getQijeu().getCompetition().getNom():null);
        this.idClient = (qiJeuResultat.getQijeu()!=null && qiJeuResultat.getQijeu().getCompetition() != null && qiJeuResultat.getQijeu().getCompetition().getClient()!= null?qiJeuResultat.getQijeu().getCompetition().getClient().getId():null);
        this.nomClient = (qiJeuResultat.getQijeu()!=null && qiJeuResultat.getQijeu().getCompetition() != null&& qiJeuResultat.getQijeu().getCompetition().getClient()!= null?qiJeuResultat.getQijeu().getCompetition().getClient().getNom():null);
        this.points = qiJeuResultat.getPoints();
        this.dateCreation = qiJeuResultat.getDateCreation();
        this.dateModification = qiJeuResultat.getDateModification();
    }

    public QiJeuResultatDto() {
    }


    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Long getIdQiJeu() {
        return idQiJeu;
    }

    public void setIdQiJeu(Long idQiJeu) {
        this.idQiJeu = idQiJeu;
    }

    public String getNomQiJeu() {
        return nomQiJeu;
    }

    public void setNomQiJeu(String nomQiJeu) {
        this.nomQiJeu = nomQiJeu;
    }

    public Long getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(Long idCompetition) {
        this.idCompetition = idCompetition;
    }

    public String getNomCompetition() {
        return nomCompetition;
    }

    public void setNomCompetition(String nomCompetition) {
        this.nomCompetition = nomCompetition;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

   
    
}
