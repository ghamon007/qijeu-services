package com.game.qijeu.business;

import java.util.Optional;
import java.util.UUID;

import com.game.qijeu.domain.Utilisateur;
import com.game.qijeu.jpa.repository.UtilisateurRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class UtilisateurServices {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    public String login(String username, String password) {
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findByLoginAndPassword(username, password);
        if(utilisateurOpt.isPresent()){
            String token = UUID.randomUUID().toString();
            Utilisateur utilisateur= utilisateurOpt.get();
            utilisateur.setToken(token);
            utilisateurRepository.save(utilisateur);
            return token;
        }

        return StringUtils.EMPTY;
    }

    public Optional<User> findByToken(String token) {
        Optional<Utilisateur> utilisateurOpt= utilisateurRepository.findByToken(token);
        if(utilisateurOpt.isPresent()){
            Utilisateur utilisateur = utilisateurOpt.get();
            User user= new User(utilisateur.getLogin(), utilisateur.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return  Optional.empty();
    }
    
}
