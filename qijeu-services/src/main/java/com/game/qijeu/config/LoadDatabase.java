package com.game.qijeu.config;

import com.game.qijeu.domain.Parametre;
import com.game.qijeu.domain.Utilisateur;
import com.game.qijeu.jpa.repository.ParametreRepository;
import com.game.qijeu.jpa.repository.UtilisateurRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(ParametreRepository repository, UtilisateurRepository userRepository) {

    return args -> {
      log.info("Preloading " + repository.save(new Parametre("PROFIL_ADMIN", "Administrateur", "PROFIL")));
      log.info("Preloading " + repository.save(new Parametre("PROFIL_MANAGER", "Gestionnaire", "PROFIL")));
      log.info("Preloading " + repository.save(new Parametre("STATUT_ACTIF", "Actif", "STATUT")));
      log.info("Preloading " + repository.save(new Parametre("STATUT_BLOQUE", "Bloqué", "STATUT")));
      log.info("Preloading " + repository.save(new Parametre("STATUT_INIT", "Initialisé", "STATUT")));
      log.info("Preloading " + userRepository.save(new Utilisateur("admin", "admin", "guillaume.hamon@gmail.com")));

    };
  }
}