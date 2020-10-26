package com.game.qijeu.dto;

import java.io.Serializable;
import java.util.Date;

import com.game.qijeu.domain.Competition;

public class CompetitionDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -407764962223856216L;

    private Long id;

    private String nom;

    private Date dateDebut;

    private Date dateFin;

    private Long idClient;

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

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public CompetitionDto() {
    }

    public CompetitionDto(Competition aCompetition) {
        this.id = aCompetition.getId();
        this.nom = aCompetition.getNom();
        this.idClient = (aCompetition.getClient() !=null?aCompetition.getClient().getId():null);
        this.dateCreation = aCompetition.getDateCreation();
        this.dateModification = aCompetition.getDateModification();
        this.dateDebut = aCompetition.getDateDebut();
        this.dateFin = aCompetition.getDateFin();
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "CompetitionDto [dateCreation=" + dateCreation + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
                + ", dateModification=" + dateModification + ", id=" + id + ", idClient=" + idClient + ", nom=" + nom
                + "]";
    }


    
}
