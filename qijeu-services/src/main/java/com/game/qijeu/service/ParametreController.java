package com.game.qijeu.service;

import java.util.ArrayList;
import java.util.List;

import com.game.qijeu.domain.Parametre;
import com.game.qijeu.exception.ClientNotFoundException;
import com.game.qijeu.jpa.repository.ContactRepository;
import com.game.qijeu.jpa.repository.ParametreRepository;

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
@RequestMapping("/param")
@CrossOrigin(origins = "*")
public class ParametreController {

	@Autowired
	ParametreRepository parametreRepository;

	@Autowired
	ContactRepository contactRepository;

	@GetMapping("/list")
	public List<Parametre> all() {
		List<Parametre> result = new ArrayList<>();
		parametreRepository.findAll().forEach(result::add);
		return result;
	}

	@GetMapping("/list/statut")
	public List<Parametre> getSatuts() {
		List<Parametre> result = new ArrayList<>();
		parametreRepository.findByType("STATUT").forEach(result::add);
		return result;
	}

    @GetMapping("/list/profil")
	public List<Parametre> getProfils() {
		List<Parametre> result = new ArrayList<>();
		parametreRepository.findByType("PROFIL").forEach(result::add);
		return result;
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public Parametre one(@PathVariable Long id) {
		return parametreRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
	}

	@PostMapping("/create")
	public Parametre saveClient(@RequestBody Parametre parametre) {
		return parametreRepository.save(parametre);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		parametreRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public Parametre replace(@RequestBody Parametre newParam, @PathVariable Long id) {
		Parametre aParam = this.one(id);
        aParam.setCode(newParam.getCode());
        aParam.setLibelle(newParam.getLibelle());
        aParam.setDescription(newParam.getDescription());
        aParam.setType(newParam.getType());
        
		parametreRepository.save(aParam);
		return aParam;
	}
}
