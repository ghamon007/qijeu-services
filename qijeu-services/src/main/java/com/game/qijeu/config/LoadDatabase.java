package com.game.qijeu.config;

import com.game.qijeu.domain.Client;
import com.game.qijeu.jpa.repository.ClientRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(ClientRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Client("Bar du matin", "place Verdun","64000","Pau","France")));
      log.info("Preloading " + repository.save(new Client("Le Millenium", "rue Victor Hugo","31000","Toulouse","France")));
    };
  }
}