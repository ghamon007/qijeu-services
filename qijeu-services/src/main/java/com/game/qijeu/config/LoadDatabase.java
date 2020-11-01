package com.game.qijeu.config;

import com.game.qijeu.domain.Client;
import com.game.qijeu.domain.Parametre;
import com.game.qijeu.domain.Utilisateur;
import com.game.qijeu.jpa.repository.ClientRepository;
import com.game.qijeu.jpa.repository.ParametreRepository;
import com.game.qijeu.jpa.repository.UtilisateurRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean(name = MultipartFilter.DEFAULT_MULTIPART_RESOLVER_BEAN_NAME)
  protected MultipartResolver getMultipartResolver() {
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    multipartResolver.setMaxUploadSize(120971520);// size in bytes
    multipartResolver.setMaxInMemorySize(120971520);// size in bytes
    return multipartResolver;
  }

  @Bean
  CommandLineRunner initDatabase(ParametreRepository repository, UtilisateurRepository userRepository,
      ClientRepository clientRepository) {

    return args -> {
      log.info("Preloading " + repository.save(new Parametre("PROFIL_ADMIN", "Administrateur", "PROFIL")));
      log.info("Preloading " + repository.save(new Parametre("PROFIL_MANAGER", "Gestionnaire", "PROFIL")));
      log.info("Preloading " + repository.save(new Parametre("STATUT_ACTIF", "Actif", "STATUT")));
      log.info("Preloading " + repository.save(new Parametre("STATUT_BLOQUE", "Bloqué", "STATUT")));
      log.info("Preloading " + repository.save(new Parametre("STATUT_INIT", "Initialisé", "STATUT")));
      log.info("Preloading " + userRepository.save(new Utilisateur("admin", "admin", "guillaume.hamon@gmail.com",
          "ghamon@test.fr", "0663366705", "0950880929")));
      log.info("Preloading "
          + clientRepository.save(new Client("Bar de test", "Bd Alsace Lorraine", "31000", "Toulouse", "France")));

    };
  }
}