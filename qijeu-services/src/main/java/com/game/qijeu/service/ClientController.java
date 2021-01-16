package com.game.qijeu.service;

import java.util.ArrayList;
import java.util.List;

import com.game.qijeu.domain.Client;
import com.game.qijeu.dto.ClientDto;
import com.game.qijeu.exception.ClientNotFoundException;
import com.game.qijeu.jpa.repository.ClientRepository;

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
@CrossOrigin(origins = { "http://localhost:8090", "https://hamonavie.fr/api", "*" })
public class ClientController {

	@Autowired
	ClientRepository clientRepository;

	@GetMapping("/list")
	public List<ClientDto> all() {
		List<ClientDto> result = new ArrayList<>();
		for (Client client : clientRepository.findAll()) {
			ClientDto clientDto = new ClientDto(client);
			result.add(clientDto);
		}
		return result;
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public ClientDto one(@PathVariable Long id) {
		Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
		return new ClientDto(client);
	}

	@PostMapping("/create")
	public Client saveClient(@RequestBody ClientDto clientDto) {
		Client client = new Client(clientDto);
		return clientRepository.save(client);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		clientRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public ClientDto replace(@RequestBody Client newClient, @PathVariable Long id) {
		Client aClient = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
		aClient.setNom(newClient.getNom());
		aClient.setAdresse(newClient.getAdresse());
		aClient.setCodePostal(newClient.getCodePostal());
		aClient.setCommune(newClient.getCommune());
		aClient.setPays(newClient.getPays());
		clientRepository.save(aClient);
		return new ClientDto(aClient);
	}
}
