package com.equinooxe.module.cleaning;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.equinooxe.domain.AgentUser;
import com.equinooxe.domain.CleanRequest;
import com.equinooxe.domain.CleanTask;
import com.equinooxe.domain.Espace;
import com.equinooxe.domain.TacheDefinition;
import com.equinooxe.module.common.BaseFormModel;

public class CleanRequestFormModel extends BaseFormModel {
    private Long id;
	private LocalDateTime startAt;
	private LocalDateTime deadlineDate;
	private AgentUser agent;
	private Espace espace;
	private String instructions;
	private Collection<CleanTask> cleanTasks;

	/**
	 * Lists to display options
	 */
	private List<Espace> availableEspaces = new ArrayList<>();
	private List<AgentUser> availableAgents = new ArrayList<>();
	private List<TacheDefinition> availableTaches = new ArrayList<>();

	/**
	 * From the form back to servers
	 */
	private Long espaceId;
	private Long agentId;
	private List<Long> tachesIds;

	private String startAtStr;
	private String deadlineDateStr;

	public CleanRequestFormModel(CleanRequest cl) {
		this.startAt = cl.getStartAt();
		this.deadlineDate= cl.getDeadlineDate();
		this.agent= cl.getAgent();
		this.espace= cl.getEspace();
		this.instructions= cl.getInstructions();
		this.cleanTasks = cl.getCleanTasks();
		this.id= cl.getId();
	}

	public String getStartAtStr() {
		return startAtStr;
	}

	public void setStartAtStr(String startAtStr) {
		this.startAtStr = startAtStr;
	}

	public String getDeadlineDateStr() {
		return deadlineDateStr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDeadlineDateStr(String deadlineDateStr) {
		this.deadlineDateStr = deadlineDateStr;
	}

	public CleanRequestFormModel() {
		super();
		this.startAt = LocalDateTime.now().plusDays(1);
		this.deadlineDate = LocalDateTime.now().plusDays(2);
	}

	public CleanRequestFormModel(List<AgentUser> availableAgents, List<Espace> availableEspace,
			List<TacheDefinition> availableTaches) {
		super();
		this.startAt = LocalDateTime.now().plusDays(1);
		this.deadlineDate = LocalDateTime.now().plusDays(2);
		this.availableAgents = availableAgents;
		this.availableEspaces = availableEspace;
		this.availableTaches = availableTaches;
	}

	public LocalDateTime getStartAt() {
		return startAt;
	}

	public Long getAgentId() {
		return agentId;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public void setStartAt(LocalDateTime startAt) {
		this.startAt = startAt;
	}

	public LocalDateTime getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(LocalDateTime deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public AgentUser getAgent() {
		return agent;
	}

	public void setAgent(AgentUser agent) {
		this.agent = agent;
	}

	public List<AgentUser> getAvailableAgents() {
		return availableAgents;
	}

	public void setAvailableAgents(List<AgentUser> availableAgents) {
		this.availableAgents = availableAgents;
	}

	public Espace getEspace() {
		return espace;
	}

	public void setEspace(Espace espace) {
		this.espace = espace;
	}

	public Long getEspaceId() {
		return espaceId;
	}

	public void setEspaceId(Long espaceId) {
		this.espaceId = espaceId;
	}

	public List<Espace> getAvailableEspaces() {
		return availableEspaces;
	}

	public void setAvailableEspaces(List<Espace> availableEspaces) {
		this.availableEspaces = availableEspaces;
	}

	public List<TacheDefinition> getAvailableTaches() {
		return availableTaches;
	}

	public void setAvailableTaches(List<TacheDefinition> availableTaches) {
		this.availableTaches = availableTaches;
	}

	public List<Long> getTachesIds() {
		return tachesIds;
	}

	public void setTachesIds(List<Long> tachesIds) {
		this.tachesIds = tachesIds;
	}

	public Collection<CleanTask> getCleanTasks() {
		return cleanTasks;
	}

	public void setCleanTasks(Collection<CleanTask> cleanTasks) {
		this.cleanTasks = cleanTasks;
	}

}
