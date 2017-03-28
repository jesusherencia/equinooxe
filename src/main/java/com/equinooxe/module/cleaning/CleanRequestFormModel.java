package com.equinooxe.module.cleaning;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.equinooxe.domain.AgentUser;
import com.equinooxe.module.common.BaseFormModel;

public class CleanRequestFormModel extends BaseFormModel {
	private LocalDateTime startAt;
	private LocalDateTime deadlineDate;
	private AgentUser agent;
	private Long agentId;

	private List<AgentUser> availableAgents = new ArrayList<>();

	public CleanRequestFormModel() {
		super();
		this.startAt = LocalDateTime.now().plusDays(1);
		this.deadlineDate = LocalDateTime.now().plusDays(2);
	}

	public CleanRequestFormModel(List<AgentUser> availableAgents) {
		super();
		this.startAt = LocalDateTime.now().plusDays(1);
		this.deadlineDate = LocalDateTime.now().plusDays(2);
		this.availableAgents = availableAgents;
	}

	public LocalDateTime getStartAt() {
		return startAt;
	}

	public Long getAgentId() {
		return agentId;
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
  
}
