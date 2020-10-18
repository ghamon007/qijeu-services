package com.game.qijeu.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.game.qijeu.domain.Client;

@RunWith(SpringRunner.class)
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
		Assert.assertEquals(client1.getNom(), foundClients.get(0).getNom());
		
	}

}
