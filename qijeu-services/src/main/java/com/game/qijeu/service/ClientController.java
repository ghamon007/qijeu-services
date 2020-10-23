package com.game.qijeu.service;

import java.util.ArrayList;
import java.util.List;

import com.game.qijeu.domain.Client;
import com.game.qijeu.exception.ClientNotFoundException;
import com.game.qijeu.jpa.repository.ClientRepository;
import com.game.qijeu.jpa.repository.ContactRepository;

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
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientController {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	ContactRepository contactRepository;

	@GetMapping("/list")
	public List<Client> all() {
		List<Client> result = new ArrayList<>();
		clientRepository.findAll().forEach(result::add);
		return result;
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public Client one(@PathVariable Long id) {
		return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
	}

	@PostMapping("/create")
	public Client saveClient(@RequestBody Client client) {
		return clientRepository.save(client);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		clientRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public Client replace(@RequestBody Client newClient, @PathVariable Long id) {
		Client aClient = this.one(id);
		aClient.setNom(newClient.getNom());
		aClient.setAdresse(newClient.getAdresse());
		aClient.setCodePostal(newClient.getCodePostal());
		aClient.setCommune(newClient.getCommune());
		aClient.setPays(newClient.getPays());
		clientRepository.save(aClient);
		return aClient;
	}
}
