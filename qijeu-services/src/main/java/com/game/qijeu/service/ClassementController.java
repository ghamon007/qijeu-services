package com.game.qijeu.service;

import java.util.ArrayList;
import java.util.List;

import com.game.qijeu.domain.QiJeu;
import com.game.qijeu.domain.QiJeuResultat;
import com.game.qijeu.dto.QiJeuResultatDto;
import com.game.qijeu.exception.QiJeuNotFoundException;
import com.game.qijeu.jpa.repository.QiJeuRepository;
import com.game.qijeu.jpa.repository.QiJeuResultatRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classement")
public class ClassementController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassementController.class);

    @Autowired
    QiJeuResultatRepository qiJeuResultatRepository;

    @Autowired
    QiJeuRepository qiJeuRepository;

    @GetMapping(path = "/{id}", produces = "application/json")
    public List<QiJeuResultatDto> classementByCompetition(@PathVariable Long id) {
        QiJeu qiJeu = qiJeuRepository.findById(id).orElseThrow(() -> new QiJeuNotFoundException(id));

        List<QiJeuResultatDto> result = new ArrayList<>();
        int classement = 1;
        for (QiJeuResultat qiJeuResultat : qiJeuResultatRepository.findByQijeuOrderByPointsDesc(qiJeu)) {
            QiJeuResultatDto qiJeuResultatDto = new QiJeuResultatDto(qiJeuResultat);
            qiJeuResultatDto.setClassement(classement++);
            result.add(qiJeuResultatDto);
        }
        return result;
    }

}
