package com.game.qijeu.jpa.repository;

import java.util.List;
import java.util.Optional;

import com.game.qijeu.domain.Parametre;

import org.springframework.data.repository.CrudRepository;

public interface ParametreRepository extends CrudRepository<Parametre, Long>{
    
    public List<Parametre> findByType(String type);

    public Optional<Parametre> findByCode(String code);
 
}
