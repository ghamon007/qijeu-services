package com.game.qijeu.service;

import java.util.ArrayList;
import java.util.List;

import com.game.qijeu.domain.Client;
import com.game.qijeu.domain.Equipe;
import com.game.qijeu.dto.EquipeDto;
import com.game.qijeu.exception.ClientNotFoundException;
import com.game.qijeu.exception.EquipeNotFoundException;
import com.game.qijeu.jpa.repository.ClientRepository;
import com.game.qijeu.jpa.repository.EquipeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipe")
@CrossOrigin(origins = "*")
public class EquipeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EquipeController.class);

    @Autowired
	EquipeRepository equipeRepository;
	
	@Autowired
	ClientRepository clientRepository;

	@GetMapping("/list")
	public List<EquipeDto> all() {
		List<EquipeDto> result = new ArrayList<>();
		for (Equipe equipe : equipeRepository.findAll()) {
			EquipeDto equipeDto =new EquipeDto(equipe);
			result.add(equipeDto);
		}
		return result;
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public EquipeDto one(@PathVariable Long id) {
		Equipe equipe = equipeRepository.findById(id).orElseThrow(() -> new EquipeNotFoundException(id)); 
		return new EquipeDto(equipe);
	}

	@PostMapping("/create")
	public EquipeDto saveEquipe(@RequestBody EquipeDto equipeDto){
		LOGGER.info(equipeDto.toString());
		Client client = clientRepository.findById(equipeDto.getIdClient()).orElseThrow(() -> new ClientNotFoundException(equipeDto.getId()));
		Equipe equipe = new Equipe(equipeDto);
		equipe.setClient(client);
		equipe = equipeRepository.save(equipe);
		return new EquipeDto(equipe);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		equipeRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public EquipeDto replace(@RequestBody EquipeDto newEquipe, @PathVariable Long id) {
		Equipe aEquipe = equipeRepository.findById(id).orElseThrow(() -> new EquipeNotFoundException(id));
		aEquipe.setNom(newEquipe.getNom());
		aEquipe.setEmail1(newEquipe.getEmail1());
		aEquipe.setEmail2(newEquipe.getEmail2());
		aEquipe.setTelephone1(newEquipe.getTelephone1());
		aEquipe.setTelephone2(newEquipe.getTelephone2());
		Client client = clientRepository.findById(newEquipe.getIdClient()).orElseThrow(() -> new ClientNotFoundException(newEquipe.getId()));
		aEquipe.setClient(client);
		equipeRepository.save(aEquipe);
		return new EquipeDto(aEquipe);
	}
}
