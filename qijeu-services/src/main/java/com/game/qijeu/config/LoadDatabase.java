package com.game.qijeu.config;

import java.util.Calendar;
import java.util.Optional;

import com.game.qijeu.domain.Client;
import com.game.qijeu.domain.Competition;
import com.game.qijeu.domain.Equipe;
import com.game.qijeu.domain.Parametre;
import com.game.qijeu.domain.QiJeu;
import com.game.qijeu.domain.QiJeuResultat;
import com.game.qijeu.domain.Utilisateur;
import com.game.qijeu.jpa.repository.ClientRepository;
import com.game.qijeu.jpa.repository.CompetitionRepository;
import com.game.qijeu.jpa.repository.EquipeRepository;
import com.game.qijeu.jpa.repository.ParametreRepository;
import com.game.qijeu.jpa.repository.QiJeuRepository;
import com.game.qijeu.jpa.repository.QiJeuResultatRepository;
import com.game.qijeu.jpa.repository.UtilisateurRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Value("${spring.servlet.multipart.max-file-size}")
  private String maxFileSize;

  @Bean(name = MultipartFilter.DEFAULT_MULTIPART_RESOLVER_BEAN_NAME)
  protected MultipartResolver getMultipartResolver() {
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    DataSize dataSize = DataSize.parse(maxFileSize);
    log.info("Max file size to upload  = " + dataSize.toBytes());
    multipartResolver.setMaxUploadSize(dataSize.toBytes());// size in bytes
    multipartResolver.setMaxInMemorySize((int) dataSize.toBytes());// size in bytes
    return multipartResolver;
  }

  @Bean
  CommandLineRunner initDatabase(ParametreRepository repository, UtilisateurRepository userRepository,
      ClientRepository clientRepository, CompetitionRepository competitionRepository, EquipeRepository equipeRepository, QiJeuRepository qiJeuRepository, QiJeuResultatRepository qiJeuResultatRepository){

    return args -> {
      log.info("Preloading " + repository.save(new Parametre("PROFIL_ADMIN", "Administrateur", "PROFIL")));
      log.info("Preloading " + repository.save(new Parametre("PROFIL_MANAGER", "Gestionnaire", "PROFIL")));
      log.info("Preloading " + repository.save(new Parametre("STATUT_ACTIF", "Actif", "STATUT")));
      log.info("Preloading " + repository.save(new Parametre("STATUT_BLOQUE", "Bloqué", "STATUT")));
      log.info("Preloading " + repository.save(new Parametre("STATUT_INIT", "Initialisé", "STATUT")));
      Optional<Parametre> statut =  repository.findByCode("STATUT_ACTIF");
      Optional<Parametre> profil =  repository.findByCode("PROFIL_ADMIN");
      log.info("Preloading " + userRepository.save(new Utilisateur("admin", "admin", statut.get(), profil.get())));
      Client client = new Client("Bar de test", "Bd Alsace Lorraine", "31000", "Toulouse", "France");
      log.info("Preloading "+ clientRepository.save(client));
      Calendar dateDebut = Calendar.getInstance();
      Calendar dateFin  = Calendar.getInstance();
      Competition competition =  new Competition("Saison 2020-2021", dateDebut.getTime(), dateFin.getTime(), client);
      dateFin.add(Calendar.YEAR, 1);
      log.info("Preloading "+ competitionRepository.save(competition));
      Equipe[] equipes = new Equipe[10];
      for (int i = 0; i < 10; i++) {
        equipes[i] = new Equipe("Equipe "+i,"equipe"+i+"@gmail.com", client);
        log.info("Preloading "+ equipeRepository.save(equipes[i]));  
      }

      QiJeu[] qiJeux = new QiJeu[10];
      for (int i = 0; i < 10; i++) {
        Calendar dateQiJeu = Calendar.getInstance();
        dateQiJeu.add(Calendar.MONTH, i);
        qiJeux[i] = new QiJeu("Journee "+i,dateQiJeu.getTime(), competition);
        log.info("Preloading "+ qiJeuRepository.save(qiJeux[i]));
      }

      for (QiJeu qiJeu : qiJeux) {
        for (Equipe equipe : equipes) {
          Integer points = (int) Math.round(Math.random()*100);
          QiJeuResultat qiJeuResultat = new QiJeuResultat(qiJeu, equipe,points);
          log.info("Preloading "+ qiJeuResultatRepository.save(qiJeuResultat));
        }
        
      }

    };
  }
}