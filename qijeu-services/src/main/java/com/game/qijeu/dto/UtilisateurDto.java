package com.game.qijeu.dto;

import java.io.Serializable;
import java.util.Date;

import com.game.qijeu.domain.Utilisateur;

public class UtilisateurDto implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 5902065575591131273L;

    private Long id;
	
	private String login;
	
	private String password;
	
    private String email1;
    
    private String email2;

    private String telephone1;

    private String telephone2;

    private String codeStatut;

    private String codeProfil;

    private Date dateCreation;

    private Date dateModification;

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
        this.email1 = utilisateur.getEmail1();
        this.email2 = utilisateur.getEmail2();
        this.telephone1 = utilisateur.getTelephone1();
        this.telephone2 = utilisateur.getTelephone2();
        this.codeProfil = (utilisateur.getProfil()!=null?utilisateur.getProfil().getCode():null);
        this.codeStatut = (utilisateur.getStatut()!=null?utilisateur.getStatut().getCode():null);
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

    
}
