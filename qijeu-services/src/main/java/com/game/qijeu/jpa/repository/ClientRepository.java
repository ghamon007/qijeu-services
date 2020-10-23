package com.game.qijeu.jpa.repository;

import java.util.List;

import com.game.qijeu.domain.Client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends CrudRepository<Client, Long> {
	
	List<Client> findByNomIgnoreCaseStartingWith(@Param("nom") String nom);

}
