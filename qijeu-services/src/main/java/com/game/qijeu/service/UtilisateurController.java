package com.game.qijeu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.game.qijeu.domain.Client;
import com.game.qijeu.domain.Parametre;
import com.game.qijeu.domain.Utilisateur;
import com.game.qijeu.dto.UtilisateurDto;
import com.game.qijeu.jpa.repository.ClientRepository;
import com.game.qijeu.jpa.repository.ParametreRepository;
import com.game.qijeu.jpa.repository.UtilisateurRepository;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "http://localhost:8090", "https://hamonavie.fr/api", "*" })
public class UtilisateurController {

	private static Logger LOGGER = LoggerFactory.getLogger(UtilisateurController.class);

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Autowired
	ParametreRepository parametreRepository;

	@Autowired
	ClientRepository clientRepository;

	// @Autowired
	// PasswordEncoder passwordEncoder;

	@PostMapping("/token")
    public String findByToken(@RequestParam("username") final String username, @RequestParam("password") final String password){
		String token = null;
		Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByLoginAndPassword(username,password);
        if(utilisateurOptional.isPresent()){
            token = UUID.randomUUID().toString();
            Utilisateur utilisateur= utilisateurOptional.get();
            utilisateur.setToken(token);
            utilisateurRepository.save(utilisateur);
            return token;
        }
        return "no token found";
    }

	/**
	 * @PostMapping("/login") public Map<String, Object>
	 * login(@AuthenticationPrincipal OAuth2User principal) { LOGGER.info("Login de
	 * l'utilisateur : " + principal.getAttribute("name")); return
	 * Collections.singletonMap("name", principal.getAttribute("name")); }
	 */

	@GetMapping("/list")
	public List<UtilisateurDto> all() {
		List<UtilisateurDto> result = new ArrayList<>();

		for (Utilisateur utilisateur : utilisateurRepository.findAll()) {
			UtilisateurDto utilisateurDto = new UtilisateurDto(utilisateur);
			result.add(utilisateurDto);
		}
		return result;
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public UtilisateurDto oneByid(@PathVariable Long id) {
		Optional<Utilisateur> utilisateurPresent = utilisateurRepository.findById(id);
		UtilisateurDto utilisateurDto = (utilisateurPresent.isPresent() ? new UtilisateurDto(utilisateurPresent.get())
				: null);
		return utilisateurDto;
	}

	@PostMapping("/create")
	public UtilisateurDto saveUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
		Utilisateur utilisateur = new Utilisateur(utilisateurDto);
		/// utilisateur.setPassword(passwordEncoder.encode(utilisateurDto.getPassword()));
		Optional<Parametre> aStatut = parametreRepository.findByCode(utilisateurDto.getCodeStatut());
		utilisateur.setStatut(aStatut.isPresent() ? aStatut.get() : null);
		Optional<Parametre> aProfil = parametreRepository.findByCode(utilisateurDto.getCodeProfil());
		utilisateur.setProfil(aProfil.isPresent() ? aProfil.get() : null);
		Optional<Client> aClient = clientRepository.findById(utilisateurDto.getIdClient());
		utilisateur.setClient(aClient.isPresent() ? aClient.get() : null);
		utilisateurRepository.save(utilisateur);
		return utilisateurDto;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		utilisateurRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public UtilisateurDto replace(@RequestBody UtilisateurDto newUtilisateur, @PathVariable Long id) {
		Optional<Utilisateur> aUtilisateurPresent = utilisateurRepository.findById(id);
		Utilisateur aUtilisateur = (aUtilisateurPresent.isPresent() ? aUtilisateurPresent.get() : new Utilisateur());
		aUtilisateur.setLogin(newUtilisateur.getLogin());
		// aUtilisateur.setPassword(passwordEncoder.encode(newUtilisateur.getPassword()));

		Optional<Parametre> aStatut = parametreRepository.findByCode(newUtilisateur.getCodeStatut());
		Optional<Parametre> aProfil = parametreRepository.findByCode(newUtilisateur.getCodeProfil());
		Optional<Client> aClient = clientRepository.findById(newUtilisateur.getIdClient());

		aUtilisateur.setProfil(aProfil.isPresent() ? aProfil.get() : null);
		aUtilisateur.setStatut(aStatut.isPresent() ? aStatut.get() : null);
		aUtilisateur.setClient(aClient.isPresent() ? aClient.get() : null);
		utilisateurRepository.save(aUtilisateur);
		return newUtilisateur;
	}

}
