package com.game.qijeu.dto;

import java.io.Serializable;
import java.util.List;

import com.game.qijeu.domain.Client;

public class ClientDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -951989859380540645L;

    private Long id;

    private String nom;

	private String adresse;

	private String codePostal;

	private String commune;

	private String pays;

	private String email1;

	private String email2;

	private String telephone1;

    private String telephone2;
    
    private List<Long> qiJeux;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getQiJeux() {
        return qiJeux;
    }

    public void setQiJeux(List<Long> qiJeux) {
        this.qiJeux = qiJeux;
    }
  
    public ClientDto() {
    }

    public ClientDto(Client client) {
        this.setId(client.getId());
        this.setNom(client.getNom());
        this.setAdresse(client.getAdresse());
        this.setCodePostal(client.getCodePostal());
        this.setCommune(client.getCommune());
        this.setPays(client.getPays());
        this.setEmail1(client.getEmail1());
        this.setEmail2(client.getEmail2());
        this.setTelephone1(client.getTelephone1());
        this.setTelephone2(client.getTelephone2());

    }

   

}
