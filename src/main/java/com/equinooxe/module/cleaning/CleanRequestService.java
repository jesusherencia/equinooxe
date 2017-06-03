package com.equinooxe.module.cleaning;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equinooxe.domain.AgentUser;
import com.equinooxe.domain.CleanRequest;
import com.equinooxe.domain.CleanTask;
import com.equinooxe.domain.Espace;
import com.equinooxe.domain.ManagerUser;
import com.equinooxe.domain.TacheDefinition;
import com.equinooxe.module.taches.TacheDefinitionQueryRepository;
import com.equinooxe.repository.AgentUserQueryRepository;
import com.equinooxe.repository.CleanRequestQueryRepository;
import com.equinooxe.repository.CleanRequestRepository;
import com.equinooxe.repository.CleanTaskRepository;
import com.equinooxe.repository.EspaceQueryRepository;
import com.equinooxe.repository.EspaceRepository;
import com.equinooxe.repository.EtageRepository;
import com.equinooxe.repository.ManagerUserQueryRepository;

@Service
@Transactional
public class CleanRequestService {
	@Inject
	CleanRequestQueryRepository cleanRequestQueryRepository;
	@Inject
	ManagerUserQueryRepository managerUserQueryRep;
	@Inject
	AgentUserQueryRepository agentUserQueryRep;
	@Inject
	EspaceQueryRepository espaceQueryRep;
	@Inject
	EspaceRepository espaceRepository;
	@Inject
	EtageRepository etageRepository;
	@Inject
	CleanRequestRepository cleanRequestRepo;
	@Inject
	ManagerUserQueryRepository managerQueryRep;
	@Inject
	TacheDefinitionQueryRepository tachesDefQueryRep;
	@Inject
	CleanTaskRepository cleanTaskRepo;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

	public CleanRequest addNew(CleanRequestFormModel form) {
		CleanRequest cleanRequest = new CleanRequest();
		cleanRequest = this.buildCleanRequest(form, cleanRequest);
		return cleanRequestRepo.saveAndFlush(cleanRequest);
	}

	public CleanRequest updateFrom(CleanRequestFormModel form) {
		CleanRequest cleanRequest = cleanRequestQueryRepository.getOneById(form.getId());
		cleanRequest = this.buildCleanRequest(form, cleanRequest);
		return cleanRequestRepo.saveAndFlush(cleanRequest);
	}

	public CleanRequest buildCleanRequest(CleanRequestFormModel form, CleanRequest cleanRequest) {
		Espace espace = espaceRepository.findOne(form.getEspaceId());
		AgentUser agent = agentUserQueryRep.getOneById(form.getAgentId());
		cleanRequest.setAgent(agent);
		cleanRequest.setEspace(espace);
		cleanRequest.setInstructions(form.getInstructions());
		cleanRequest.setDeadlineDate(LocalDateTime.parse(form.getDeadlineDateStr(), formatter));
		cleanRequest.setStartAt(LocalDateTime.parse(form.getStartAtStr(), formatter));
		ManagerUser um = managerQueryRep.getCurrent();
		cleanRequest.setManager(um);
		Set<CleanTask> cls= buildCleanTasksFrom(form,cleanRequest);
		cls.forEach(c->{ 
			c.setCleanRequest(cleanRequest);
			cleanTaskRepo.save(c);
		});
		cleanRequest.addAll(cls);
		return cleanRequest;
	}

	public Set<CleanTask> buildCleanTasksFrom(CleanRequestFormModel form, CleanRequest cleanRequest) {
		Set<CleanTask> cls = new HashSet<>();
		for (Long id : form.getTachesIds()) {
			TacheDefinition tDef = tachesDefQueryRep.getOneById(id);
			CleanTask cl = cleanTaskRepo.findOneByName(tDef.getNom());
			if (cl == null) {
				cl = new CleanTask(tDef);
			}
			cls.add(cl);
		}
		/** Dont erase on edit!  */
		if(!form.getTachesIds().isEmpty()){
			cleanRequest.getCleanTasks().forEach(e->{
				if(!cls.contains(e)){
					cleanTaskRepo.delete(e);
				}
			});	
		}
		return cls;
	}
}
