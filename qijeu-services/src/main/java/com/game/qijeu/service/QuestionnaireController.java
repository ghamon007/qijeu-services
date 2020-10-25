package com.game.qijeu.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.game.qijeu.domain.Questionnaire;
import com.game.qijeu.dto.QuestionnaireDto;
import com.game.qijeu.exception.QuestionnaireNotFoundException;
import com.game.qijeu.jpa.repository.ClientRepository;
import com.game.qijeu.jpa.repository.QuestionnaireRepository;

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
@RequestMapping("/questionnaire")
@CrossOrigin(origins = "*")
public class QuestionnaireController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EquipeController.class);

    @Autowired
    QuestionnaireRepository questionnaireRepository;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/list")
    public List<QuestionnaireDto> all() {
        List<QuestionnaireDto> result = new ArrayList<>();
        for (Questionnaire questionnaire : questionnaireRepository.findAll()) {
            QuestionnaireDto questionnaireDto = new QuestionnaireDto(questionnaire);
            result.add(questionnaireDto);
        }
        return result;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public QuestionnaireDto one(@PathVariable Long id) {
        Questionnaire questionnaire = questionnaireRepository.findById(id)
                .orElseThrow(() -> new QuestionnaireNotFoundException(id));
        return new QuestionnaireDto(questionnaire);
    }

    @PostMapping(path = "/create", consumes = { "application/json","multipart/form-data" })
    public QuestionnaireDto saveQuestionnaire(@RequestBody QuestionnaireDto questionnaireDto) {
        LOGGER.info(questionnaireDto.toString());
        Questionnaire questionnaire = new Questionnaire(questionnaireDto);
        questionnaire = questionnaireRepository.save(questionnaire);
        return new QuestionnaireDto(questionnaire);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        questionnaireRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public QuestionnaireDto replace(@RequestBody QuestionnaireDto newQuestionnaire, @PathVariable Long id) {
        Questionnaire aQuestionnaire = questionnaireRepository.findById(id)
                .orElseThrow(() -> new QuestionnaireNotFoundException(id));
        aQuestionnaire.setLibelle(newQuestionnaire.getLibelle());
        aQuestionnaire.setDescription(newQuestionnaire.getDescription());
        try {
            aQuestionnaire.setFichier(newQuestionnaire.getFichier().getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		questionnaireRepository.save(aQuestionnaire);
		return new QuestionnaireDto(aQuestionnaire);
	}
}