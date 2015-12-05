package com.game.qijeu.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(insertable = true, updatable = false)
	private Date dateCreation;
	
	@Column(insertable = false, updatable = true)
	private Date dateModification;
	
	@ManyToOne
	@JoinColumn(insertable = true, updatable = false)
	private Utilisateur utilisateurCreation;

	@ManyToOne
	@JoinColumn(insertable = false, updatable = true)
	private Utilisateur utilisateurModification;
	
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

	public Utilisateur getUtilisateurCreation() {
		return utilisateurCreation;
	}

	public void setUtilisateurCreation(Utilisateur utilisateurCreation) {
		this.utilisateurCreation = utilisateurCreation;
	}

	public Utilisateur getUtilisateurModification() {
		return utilisateurModification;
	}

	public void setUtilisateurModification(Utilisateur utilisateurModification) {
		this.utilisateurModification = utilisateurModification;
	}
	
	@PrePersist
	void preInsert() {
	   this.dateCreation = new Date();
	}
	
	@PreUpdate
	void preUpdate(){
		this.dateModification = new Date();
	}

}
