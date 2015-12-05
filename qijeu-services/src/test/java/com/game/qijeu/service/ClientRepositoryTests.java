package com.game.qijeu.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.game.qijeu.QijeuServicesApplication;
import com.game.qijeu.domain.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=QijeuServicesApplication.class)
public class ClientRepositoryTests {
	
	@Autowired ClientRepository clientRepository;

	@Test
	public void testFindByNomIgnoreCase() {
		List<Client> clients = clientRepository.findByNomIgnoreCaseStartingWith("bar");
		Assert.assertNotNull(clients);
		Assert.assertEquals("BAR DU MATIN", clients.get(0).getNom());
		
	}

}
