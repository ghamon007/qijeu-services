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

    private Long idEquipe;

    private int resultat;

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

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
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
        this.idQiJeu = qiJeuResultat.getQijeu().getId();
        this.resultat = qiJeuResultat.getPoints();
    }

    public QiJeuResultatDto() {
    }

    public Long getIdQiJeu() {
        return idQiJeu;
    }

    public void setIdQiJeu(Long idQiJeu) {
        this.idQiJeu = idQiJeu;
    }
    
    
}
