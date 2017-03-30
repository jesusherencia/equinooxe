package com.equinooxe.module.cleaning;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.equinooxe.domain.AgentUser;
import com.equinooxe.domain.Espace;
import com.equinooxe.module.common.BaseFormModel;

public class CleanRequestFormModel extends BaseFormModel {
	
	private LocalDateTime startAt;
	private LocalDateTime deadlineDate;
	private AgentUser agent;
	private Espace espace;
	private String instructions;
	
	/**
	 * Lists to display options
	 */
	private List<Espace> availableEspaces = new ArrayList<>();
	private List<AgentUser> availableAgents = new ArrayList<>();
	
	/**
	 * From the form back to servers
	 */
	private Long espaceId;
	private Long agentId;

	

	public CleanRequestFormModel() {
		super();
		this.startAt = LocalDateTime.now().plusDays(1);
		this.deadlineDate = LocalDateTime.now().plusDays(2);
	}

	public CleanRequestFormModel(List<AgentUser> availableAgents, List<Espace> availableEspace) {
		super();
		this.startAt = LocalDateTime.now().plusDays(1);
		this.deadlineDate = LocalDateTime.now().plusDays(2);
		this.availableAgents = availableAgents;
		this.availableEspaces = availableEspace;
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
  
}
