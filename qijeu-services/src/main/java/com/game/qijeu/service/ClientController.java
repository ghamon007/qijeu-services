package com.game.qijeu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.qijeu.domain.Client;
import com.game.qijeu.domain.Contact;
import com.game.qijeu.jpa.repository.ClientRepository;
import com.game.qijeu.jpa.repository.ContactRepository;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientRepository clientRepository;
	
	ContactRepository contactRepository;

	@GetMapping(path="/{id}",produces = "application/json")
    public Client getClient(@PathVariable Long id) {
		Optional<Client> isClient = clientRepository.findById(id);
		if (isClient.isPresent()) {		
			return isClient.get();
		} else {
			return null;
		}
				
    }
	
	@PutMapping(path="/create", consumes = "application/json")
	public void saveClient(@PathVariable String nom, @PathVariable String adresse, @PathVariable String email ) {
		Client client = new Client();
		client.setNom(nom);
		client.setAdresse(adresse);
		Contact contact = new Contact();
		contact.setClient(client);
		contact.setValeur(email);
		contactRepository.save(contact);
		List<Contact> contacts = new ArrayList<>();
		contacts.add(contact);
		client.setContacts(contacts);
		clientRepository.save(client);
	}
	
}
