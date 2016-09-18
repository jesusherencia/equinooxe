/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author mohamed
 */
@Entity
public class CleanRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate startAt;
    private LocalDate deadlineDate;
    private LocalDateTime doneAt;

    @Column(unique = false, columnDefinition = "TEXT")
    private String instructions;

    @Column()
    private String status;

    @ManyToOne
    private AgentUser agent;

    @ManyToOne
    private ManagerUser manager;

    @OneToMany(mappedBy = "cleanRequest", targetEntity = CleanTask.class)
    private Collection<CleanTask> cleanTasks;

    @ManyToOne
    private Location location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDate startAt) {
        this.startAt = startAt;
    }

    public LocalDate getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(LocalDate deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public LocalDateTime getDoneAt() {
        return doneAt;
    }

    public void setDoneAt(LocalDateTime doneAt) {
        this.doneAt = doneAt;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AgentUser getAgent() {
        return agent;
    }

    public void setAgent(AgentUser agent) {
        this.agent = agent;
    }

    public ManagerUser getManager() {
        return manager;
    }

    public void setManager(ManagerUser manager) {
        this.manager = manager;
    }

    public Collection<CleanTask> getCleanTasks() {
        return cleanTasks;
    }

    public void setCleanTasks(Collection<CleanTask> cleanTasks) {
        this.cleanTasks = cleanTasks;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CleanRequest)) {
            return false;
        }
        CleanRequest other = (CleanRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appnh.nettoyage.model.DemandeNettoyage[ id=" + id + " ]";
    }

}
