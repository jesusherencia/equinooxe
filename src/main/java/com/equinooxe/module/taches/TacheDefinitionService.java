package com.equinooxe.module.taches;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equinooxe.domain.TacheDefinition;
import com.equinooxe.repository.TacheDefinitionRepository;

@Service
@Transactional
public class TacheDefinitionService {
	@Inject
	TacheDefinitionRepository tacheDefinitionRepository;
	
	@Inject
	TacheDefinitionQueryRepository tacheDefinitionQueryRep;

	public TacheDefinition addNew(String nom, String description) {
		TacheDefinition td = new TacheDefinition(nom, description);
		return tacheDefinitionRepository.saveAndFlush(td);
	}

	public TacheDefinition update(Long id, String nom, String description) {
		TacheDefinition td = tacheDefinitionQueryRep.getOneById(id);
		td.setNom(nom);
		td.setDescription(description);
		
		return tacheDefinitionRepository.saveAndFlush(td);
	}

}
