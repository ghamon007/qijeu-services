package com.game.qijeu.service;

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
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionnaireController.class);

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

    @PostMapping(path = "/create", consumes = { "application/json", "multipart/form-data" })
    @Async
    public QuestionnaireDto saveQuestionnaire(@RequestParam("fichier") MultipartFile file,
            @RequestParam("nom") String nom, @RequestParam("description") String description) {
        // public QuestionnaireDto saveQuestionnaire(@RequestParam QuestionnaireDto
        // questionnaireDto) {
        /**
         * LOGGER.info(questionnaireDto.toString()); Questionnaire questionnaire = new
         * Questionnaire(questionnaireDto); questionnaire =
         * questionnaireRepository.save(questionnaire);
         **/
        LOGGER.info("Fichier" + file.getOriginalFilename());
        LOGGER.info("Libelle " + nom);
        LOGGER.info("Description " + description);

        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setNom(nom);
        questionnaire.setDescription(description);
        try {
            questionnaire.setFichier(file.getBytes());
            questionnaireRepository.save(questionnaire);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new QuestionnaireDto(questionnaire);
    }

    @GetMapping("/files/{id}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable Long id) {
        Questionnaire aQuestionnaire = questionnaireRepository.findById(id)
                .orElseThrow(() -> new QuestionnaireNotFoundException(id));

        Resource file = new ByteArrayResource(aQuestionnaire.getFichier());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + aQuestionnaire.getNom() + ".zip" + "\"").body(file);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        questionnaireRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public QuestionnaireDto replace(@RequestBody QuestionnaireDto newQuestionnaire, @PathVariable Long id) {
        Questionnaire aQuestionnaire = questionnaireRepository.findById(id)
                .orElseThrow(() -> new QuestionnaireNotFoundException(id));
        aQuestionnaire.setNom(newQuestionnaire.getNom());
        aQuestionnaire.setDescription(newQuestionnaire.getDescription());
        /**
         * try { aQuestionnaire.set(newQuestionnaire.getFichier().getBytes()); } catch
         * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
         **/
        questionnaireRepository.save(aQuestionnaire);
        return new QuestionnaireDto(aQuestionnaire);
    }
}