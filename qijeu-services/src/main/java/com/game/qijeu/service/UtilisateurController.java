package com.game.qijeu.service;

import com.game.qijeu.jpa.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UtilisateurController {
    @Autowired
	UtilisateurRepository utilisateurRepository;

}
