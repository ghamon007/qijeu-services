package com.game.qijeu.dto;

import java.io.Serializable;
import java.util.Date;

import com.game.qijeu.domain.Equipe;

public class EquipeDto implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -407764962223856216L;

    private Long id;

	private String nom;

	private String email1;

	private String email2;

	private String telephone1;

	private String telephone2;

    private Long idClient;

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

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public EquipeDto() {
    }

    public EquipeDto(Equipe aEquipe) {
        this.id = aEquipe.getId();
        this.nom = aEquipe.getNom();
        this.email1 = aEquipe.getEmail1();
        this.email2 = aEquipe.getEmail2();
        this.telephone1 = aEquipe.getTelephone1();
        this.telephone2 = aEquipe.getTelephone2();
        this.idClient = (aEquipe.getClient() !=null?aEquipe.getClient().getId():null);
        this.nomClient = (aEquipe.getClient() !=null?aEquipe.getClient().getNom():null);
        this.dateCreation = aEquipe.getDateCreation();
        this.dateModification = aEquipe.getDateModification();
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

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    @Override
    public String toString() {
        return "EquipeDto [dateCreation=" + dateCreation + ", dateModification=" + dateModification + ", email1="
                + email1 + ", email2=" + email2 + ", id=" + id + ", idClient=" + idClient + ", nom=" + nom
                + ", telephone1=" + telephone1 + ", telephone2=" + telephone2 + "]";
    }

    
}
