package com.game.qijeu.jpa.repository;

import java.util.Optional;

import com.game.qijeu.domain.Utilisateur;

import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long>{
    

    public Optional<Utilisateur> findByLoginAndPassword(String login, String password);


}
