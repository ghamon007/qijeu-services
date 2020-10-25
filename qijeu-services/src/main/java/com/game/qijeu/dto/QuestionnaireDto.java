package com.game.qijeu.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.game.qijeu.domain.Questionnaire;

import org.springframework.web.multipart.MultipartFile;

public class QuestionnaireDto {

    private Long id;

    private String libelle;

    private String description;

    private Date dateCreation;

    private Date dateModification;

    private String nomFichier;

    private List<Long> qiJeuxIds = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<Long> getQiJeuxIds() {
        return qiJeuxIds;
    }

    public void setQiJeuxIds(List<Long> qiJeuxIds) {
        this.qiJeuxIds = qiJeuxIds;
    }

    public QuestionnaireDto() {
    }

    public QuestionnaireDto(Questionnaire questionnaire){
        this.setId(questionnaire.getId());
        this.setLibelle(questionnaire.getLibelle());
        this.setDescription(questionnaire.getDescription());
        this.setDateCreation(questionnaire.getDateCreation());
        this.setDateModification(questionnaire.getDateModification());
        this.setNomFichier(questionnaire.getLibelle()+".zip");
//        this.setFichier(questionnaire.getFichier());
        
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

   
}
