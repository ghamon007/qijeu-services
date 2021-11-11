package com.game.qijeu.config;

import java.util.Calendar;

import com.game.qijeu.domain.Client;
import com.game.qijeu.domain.Competition;
import com.game.qijeu.domain.Equipe;
import com.game.qijeu.domain.QiJeu;
import com.game.qijeu.domain.QiJeuResultat;
import com.game.qijeu.jpa.repository.ClientRepository;
import com.game.qijeu.jpa.repository.CompetitionRepository;
import com.game.qijeu.jpa.repository.EquipeRepository;
import com.game.qijeu.jpa.repository.QiJeuRepository;
import com.game.qijeu.jpa.repository.QiJeuResultatRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

@Configuration
class ConfigQiJeuServices {

  private static final Logger log = LoggerFactory.getLogger(ConfigQiJeuServices.class);

  @Value("${spring.servlet.multipart.max-file-size}")
  private String maxFileSize;

  @Value("${qijeu.mode.test}")
  private boolean modeTest;

  @Value("${qijeu.nb.clients}")
  private int nbClients;

  @Value("${qijeu.nb.equipes}")
  private int nbEquipes;

  @Value("${qijeu.nb.jeux}")
  private int nbJeux;

  @Value("${qijeu.cors}")
  private String cors;

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
   public PasswordEncoder passwordEncoder() {
   PasswordEncoder encoder = new BCryptPasswordEncoder();
   return encoder;
   }

  @Bean
  CommandLineRunner initDatabase(ClientRepository clientRepository, CompetitionRepository competitionRepository,
      EquipeRepository equipeRepository, QiJeuRepository qiJeuRepository,
      QiJeuResultatRepository qiJeuResultatRepository) {

    return args -> {
      if (modeTest) {
        qiJeuResultatRepository.deleteAll();
        qiJeuRepository.deleteAll();
        competitionRepository.deleteAll();
        equipeRepository.deleteAll();
        clientRepository.deleteAll();
        Client[] clients = new Client[nbClients];
        String adresse;
        String codePostal;
        String commune;
        for (int i = 0; i < clients.length; i++) {
          if (i % 2 == 0) {
            adresse = "Bd Alsace Lorraine";
            codePostal = "31000";
            commune = "Toulouse";
          } else {
            adresse = "Bd Victor HUgo";
            codePostal = "33000";
            commune = "Bordeaux";
          }
          clients[i] = new Client("Bar de test " + i, adresse, codePostal, commune, "France");
          log.debug("Preloading " + clientRepository.save(clients[i]));
          // Creation de la saison 2020-2021 pour chaque client
          Calendar dateDebut = Calendar.getInstance();
          Calendar dateFin = Calendar.getInstance();
          dateFin.add(Calendar.YEAR, 1);
          Competition competition = new Competition("Saison 2020-2021", dateDebut.getTime(), dateFin.getTime(),
              clients[i]);
          clients[i].addCompetition(competition);
          log.debug("Preloading " + competitionRepository.save(competition));
          // Creation des equipes de test par client
          Equipe[] equipes = new Equipe[nbEquipes];
          for (int j = 0; j < equipes.length; j++) {
            equipes[j] = new Equipe("Equipe " + j, "equipe" + j + "@gmail.com", clients[i]);
            log.debug("Preloading " + equipeRepository.save(equipes[j]));
          }
          // Creation des qiJux de test par client
          QiJeu[] qiJeux = new QiJeu[nbJeux];
          for (int k = 0; k < qiJeux.length; k++) {
            Calendar dateQiJeu = Calendar.getInstance();
            dateQiJeu.add(Calendar.MONTH, k);
            qiJeux[k] = new QiJeu("Journee " + k, dateQiJeu.getTime(), clients[i].getCompetitions().get(0));
            log.debug("Preloading " + qiJeuRepository.save(qiJeux[k]));
            for (Equipe equipe : equipes) {
              Integer points = (int) Math.round(Math.random() * 100);
              QiJeuResultat qiJeuResultat = new QiJeuResultat(qiJeux[k], equipe, points);
              log.debug("Preloading " + qiJeuResultatRepository.save(qiJeuResultat));
            }

          }
        }
      }

    };
  }

}