package com.game.qijeu.service;

import java.util.ArrayList;
import java.util.List;

import com.game.qijeu.domain.Client;
import com.game.qijeu.domain.Competition;
import com.game.qijeu.dto.CompetitionDto;
import com.game.qijeu.exception.ClientNotFoundException;
import com.game.qijeu.exception.CompetitionNotFoundException;
import com.game.qijeu.jpa.repository.ClientRepository;
import com.game.qijeu.jpa.repository.CompetitionRepository;

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
@RequestMapping("/competition")
public class CompetitionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompetitionController.class);

	@Autowired
	CompetitionRepository competitionRepository;

	@Autowired
	ClientRepository clientRepository;

	@GetMapping("/list")
	public List<CompetitionDto> all() {
		List<CompetitionDto> result = new ArrayList<>();
		for (Competition competition : competitionRepository.findAll()) {
			CompetitionDto competitionDto = new CompetitionDto(competition);
			result.add(competitionDto);
		}
		return result;
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public CompetitionDto one(@PathVariable Long id) {
		Competition competition = competitionRepository.findById(id)
				.orElseThrow(() -> new CompetitionNotFoundException(id));
		return new CompetitionDto(competition);
	}

	@PostMapping("/create")
	public CompetitionDto saveCompetition(@RequestBody CompetitionDto competitionDto) {
		LOGGER.info(competitionDto.toString());
		Client client = clientRepository.findById(competitionDto.getIdClient())
				.orElseThrow(() -> new ClientNotFoundException(competitionDto.getId()));
		Competition competition = new Competition(competitionDto);
		competition.setClient(client);
		client.addCompetition(competition);
		competition = competitionRepository.save(competition);
		return new CompetitionDto(competition);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		competitionRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public CompetitionDto replace(@RequestBody CompetitionDto newCompetition, @PathVariable Long id) {
		Competition aCompetition = competitionRepository.findById(id)
				.orElseThrow(() -> new CompetitionNotFoundException(id));
		aCompetition.setNom(newCompetition.getNom());
		Client client = clientRepository.findById(newCompetition.getIdClient())
				.orElseThrow(() -> new ClientNotFoundException(newCompetition.getId()));
		aCompetition.setClient(client);
		client.addCompetition(aCompetition);
		competitionRepository.save(aCompetition);
		return new CompetitionDto(aCompetition);
	}
}
