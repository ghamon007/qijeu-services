package com.game.qijeu.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.game.qijeu.domain.Client;
import com.game.qijeu.jpa.repository.ClientRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ClientRepositoryTests {

	@Autowired TestEntityManager entityManager;
	
	@Autowired ClientRepository clientRepository;

	@Test
	public void testFindByNomIgnoreCase() {
		
		// given
	    Client client1 = new Client();
	    client1.setNom("Entreprise 1");
	    
	    entityManager.persist(client1);
	    entityManager.flush();
	 
		List<Client> foundClients = clientRepository.findByNomIgnoreCaseStartingWith("Entreprise");
	 
	    // then
		assertEquals(client1.getNom(), foundClients.get(0).getNom());
		
	}

}
