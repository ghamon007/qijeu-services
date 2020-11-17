package com.game.qijeu.service;

import java.util.ArrayList;
import java.util.List;

import com.game.qijeu.domain.Equipe;
import com.game.qijeu.domain.QiJeu;
import com.game.qijeu.domain.QiJeuResultat;
import com.game.qijeu.dto.QiJeuResultatDto;
import com.game.qijeu.exception.EquipeNotFoundException;
import com.game.qijeu.exception.QiJeuNotFoundException;
import com.game.qijeu.exception.QiJeuResultatNotFoundException;
import com.game.qijeu.jpa.repository.EquipeRepository;
import com.game.qijeu.jpa.repository.QiJeuRepository;
import com.game.qijeu.jpa.repository.QiJeuResultatRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/resultat")
@CrossOrigin("*")
public class QiJeuResultatController {

	private static final Logger LOGGER = LoggerFactory.getLogger(QiJeuResultatController.class);

	@Autowired
	QiJeuResultatRepository qiJeuResultatRepository;

	@Autowired
	QiJeuRepository qiJeuRepository;

	@Autowired
	EquipeRepository equipeRepository;

	@GetMapping("/list")
	public List<QiJeuResultatDto> all() {
		List<QiJeuResultatDto> result = new ArrayList<>();
		for (QiJeuResultat qiJeuResultat : qiJeuResultatRepository.findAll()) {
			QiJeuResultatDto qiJeuResultatDto = new QiJeuResultatDto(qiJeuResultat);
			result.add(qiJeuResultatDto);
		}
		return result;
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public QiJeuResultatDto one(@PathVariable Long id) {
		QiJeuResultat qiJeuResultat = qiJeuResultatRepository.findById(id)
				.orElseThrow(() -> new QiJeuResultatNotFoundException(id));
		return new QiJeuResultatDto(qiJeuResultat);
	}

	@PostMapping("/create")
	public QiJeuResultatDto saveQiJeuResultat(@RequestBody QiJeuResultatDto qiJeuResultatDto) {
		LOGGER.info(qiJeuResultatDto.toString());
		QiJeuResultat qiJeuResultat = new QiJeuResultat(qiJeuResultatDto);
		QiJeu qiJeu = qiJeuRepository.findById(qiJeuResultatDto.getIdQiJeu())
				.orElseThrow(() -> new QiJeuNotFoundException(qiJeuResultatDto.getIdQiJeu()));

		qiJeuResultat.setQijeu(qiJeu);

		Equipe equipe = equipeRepository.findById(qiJeuResultatDto.getIdEquipe())
				.orElseThrow(() -> new EquipeNotFoundException(qiJeuResultatDto.getIdEquipe()));
		qiJeuResultat.setEquipe(equipe);
		qiJeuResultat = qiJeuResultatRepository.save(qiJeuResultat);
		return new QiJeuResultatDto(qiJeuResultat);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		qiJeuRepository.deleteById(id);

	}

	@PutMapping("/{id}")
	public QiJeuResultatDto replace(@RequestBody QiJeuResultatDto newQiJeuResultat, @PathVariable Long id) {
		QiJeuResultat aQiJeuResultat = qiJeuResultatRepository.findById(id)
				.orElseThrow(() -> new QiJeuResultatNotFoundException(id));
		aQiJeuResultat.setPoints(newQiJeuResultat.getPoints());
		;
		QiJeu qiJeu = qiJeuRepository.findById(newQiJeuResultat.getIdQiJeu())
				.orElseThrow(() -> new QiJeuNotFoundException(newQiJeuResultat.getIdQiJeu()));
		aQiJeuResultat.setQijeu(qiJeu);

		Equipe equipe = equipeRepository.findById(newQiJeuResultat.getIdEquipe())
				.orElseThrow(() -> new EquipeNotFoundException(newQiJeuResultat.getIdEquipe()));
		aQiJeuResultat.setEquipe(equipe);
		return new QiJeuResultatDto(aQiJeuResultat);
	}

}
