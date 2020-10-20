package com.game.qijeu.service;

import java.util.ArrayList;
import java.util.List;

import com.game.qijeu.domain.Equipe;
import com.game.qijeu.exception.EquipeNotFoundException;
import com.game.qijeu.jpa.repository.EquipeRepository;

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

    @Autowired
    EquipeRepository equipeRepository;

	@GetMapping("/list")
	public List<Equipe> all() {
		List<Equipe> result = new ArrayList<>();
		equipeRepository.findAll().forEach(result::add);
		return result;
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public Equipe one(@PathVariable Long id) {
		return equipeRepository.findById(id).orElseThrow(() -> new EquipeNotFoundException(id));
	}

	@PostMapping("/create")
	public Equipe saveEquipe(@RequestBody Equipe equipe) {
		return equipeRepository.save(equipe);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		equipeRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public Equipe replace(@RequestBody Equipe newEquipe, @PathVariable Long id) {
		Equipe aEquipe = this.one(id);
		aEquipe.setNom(newEquipe.getNom());
		equipeRepository.save(aEquipe);
		return aEquipe;
	}
}
