package com.game.qijeu.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.game.qijeu.domain.Utilisateur;

public class UtilisateurDto implements Serializable {

    /**
     * 
     *
     */
    private static final long serialVersionUID = 5902065575591131273L;

    private Long id;

    @NotNull
    @Size(min = 3, max = 32)
    private String login;

    private String password;

    private String codeStatut;

    private String libelleStatut;

    private String codeProfil;

    private String libelleProfil;

    private Date dateCreation;

    private Date dateModification;

    private Long idClient;

    private String nomClient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodeStatut() {
        return codeStatut;
    }

    public void setCodeStatut(String codeStatut) {
        this.codeStatut = codeStatut;
    }

    public String getCodeProfil() {
        return codeProfil;
    }

    public void setCodeProfil(String codeProfil) {
        this.codeProfil = codeProfil;
    }

    public UtilisateurDto(Utilisateur utilisateur) {
        this.id = utilisateur.getId();
        this.login = utilisateur.getLogin();
        this.password = utilisateur.getPassword();
        this.codeProfil = (utilisateur.getProfil() != null ? utilisateur.getProfil().getCode() : null);
        this.libelleProfil = (utilisateur.getProfil() != null ? utilisateur.getProfil().getLibelle() : null);
        this.codeStatut = (utilisateur.getStatut() != null ? utilisateur.getStatut().getCode() : null);
        this.libelleStatut = (utilisateur.getStatut() != null ? utilisateur.getStatut().getLibelle() : null);
        this.idClient = (utilisateur.getClient() != null ? utilisateur.getClient().getId() : null);
        this.nomClient = (utilisateur.getClient() != null ? utilisateur.getClient().getNom() : null);

        this.dateCreation = utilisateur.getDateCreation();
        this.dateModification = utilisateur.getDateModification();
    }

    public UtilisateurDto() {
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

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getLibelleStatut() {
        return libelleStatut;
    }

    public void setLibelleStatut(String libelleStatut) {
        this.libelleStatut = libelleStatut;
    }

    public String getLibelleProfil() {
        return libelleProfil;
    }

    public void setLibelleProfil(String libelleProfil) {
        this.libelleProfil = libelleProfil;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

}
