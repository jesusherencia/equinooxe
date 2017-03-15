package com.equinooxe.module.taches;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TacheDefinitionService {
	@Inject
	TacheDefinitionRepository tacheDefinitionRepository;
	
	@Inject
	TacheDefinitionQueryRepository tacheDefinitionQueryRep;

	public TacheDefinitionEntity addNew(String nom, String description) {
		TacheDefinitionEntity td = new TacheDefinitionEntity(nom, description);
		return tacheDefinitionRepository.saveAndFlush(td);
	}

	public TacheDefinitionEntity update(Long id, String nom, String description) {
		TacheDefinitionEntity td = tacheDefinitionQueryRep.getOneById(id);
		td.setNom(nom);
		td.setDescription(description);
		
		return tacheDefinitionRepository.saveAndFlush(td);
	}

}
