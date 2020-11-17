package com.game.qijeu.jpa.repository;

import java.util.List;

import com.game.qijeu.domain.QiJeu;
import com.game.qijeu.domain.QiJeuResultat;

import org.springframework.data.repository.CrudRepository;

public interface QiJeuResultatRepository extends CrudRepository<QiJeuResultat, Long> {

    public List<QiJeuResultat> findByQijeuOrderByPointsDesc(QiJeu qijeu);

}
