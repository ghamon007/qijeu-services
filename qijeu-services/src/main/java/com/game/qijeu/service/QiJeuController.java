package com.game.qijeu.service;

import java.util.ArrayList;
import java.util.List;

import com.game.qijeu.domain.Competition;
import com.game.qijeu.domain.QiJeu;
import com.game.qijeu.domain.Questionnaire;
import com.game.qijeu.dto.QiJeuDto;
import com.game.qijeu.exception.CompetitionNotFoundException;
import com.game.qijeu.exception.QiJeuNotFoundException;
import com.game.qijeu.exception.QuestionnaireNotFoundException;
import com.game.qijeu.jpa.repository.CompetitionRepository;
import com.game.qijeu.jpa.repository.QiJeuRepository;
import com.game.qijeu.jpa.repository.QuestionnaireRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qijeu")
public class QiJeuController {

	private static final Logger LOGGER = LoggerFactory.getLogger(QiJeuController.class);

	@Autowired
	QiJeuRepository qiJeuRepository;

	@Autowired
	QuestionnaireRepository questionnaireRepository;

	@Autowired
	CompetitionRepository competitionRepository;

	@GetMapping("/list")
	public List<QiJeuDto> all() {
		List<QiJeuDto> result = new ArrayList<>();
		for (QiJeu qiJeu : qiJeuRepository.findAll()) {
			QiJeuDto qiJeuDto = new QiJeuDto(qiJeu);
			result.add(qiJeuDto);
		}
		return result;
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public QiJeuDto one(@PathVariable Long id) {
		QiJeu qiJeu = qiJeuRepository.findById(id).orElseThrow(() -> new QiJeuNotFoundException(id));
		return new QiJeuDto(qiJeu);
	}

	@PostMapping("/create")
	public QiJeuDto saveQiJeu(@RequestBody QiJeuDto qiJeuDto) {
		LOGGER.info(qiJeuDto.toString());
		QiJeu qiJeu = new QiJeu(qiJeuDto);
		Questionnaire questionnaire = questionnaireRepository.findById(qiJeuDto.getIdQuestionnaire())
				.orElseThrow(() -> new QuestionnaireNotFoundException(qiJeuDto.getId()));
		qiJeu.setQuestionnaire(questionnaire);
		Competition competition = competitionRepository.findById(qiJeuDto.getIdCompetition())
				.orElseThrow(() -> new CompetitionNotFoundException(qiJeuDto.getId()));
		qiJeu.setCompetition(competition);
		qiJeu = qiJeuRepository.save(qiJeu);
		return new QiJeuDto(qiJeu);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		qiJeuRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public QiJeuDto replace(@RequestBody QiJeuDto newQiJeu, @PathVariable Long id) {
		QiJeu aQiJeu = qiJeuRepository.findById(id).orElseThrow(() -> new QiJeuNotFoundException(id));
		aQiJeu.setNom(newQiJeu.getNom());
		aQiJeu.setDateQiJeu(newQiJeu.getDateQiJeu());
		Questionnaire questionnaire = questionnaireRepository.findById(newQiJeu.getIdQuestionnaire())
				.orElseThrow(() -> new QuestionnaireNotFoundException(id));
		aQiJeu.setQuestionnaire(questionnaire);
		Competition competition = competitionRepository.findById(newQiJeu.getIdCompetition())
				.orElseThrow(() -> new CompetitionNotFoundException(id));
		aQiJeu.setCompetition(competition);
		return new QiJeuDto(aQiJeu);
	}

}
