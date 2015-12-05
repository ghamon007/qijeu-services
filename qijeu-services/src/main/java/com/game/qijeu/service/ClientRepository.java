package com.game.qijeu.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.game.qijeu.domain.Client;

@RepositoryRestResource
public interface ClientRepository extends CrudRepository<Client, Long> {
	
	List<Client> findByNomIgnoreCaseStartingWith(@Param("nom") String nom);

}
