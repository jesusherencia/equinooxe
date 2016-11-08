/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.domain;

import com.equinooxe.resource.LocalDateTimeDeserializer;
import com.equinooxe.resource.LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * For code reuse, not intended to be a parent Entity for all Entites!
 *
 * @author mboullouz
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    protected static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "isDeleted", nullable = true)
    protected boolean isDeleted;

    @Column(name = "isArchived", nullable = true)
    protected boolean isArchived;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(name = "addAt", columnDefinition = "DATETIME")
    protected LocalDateTime addAt;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(name = "updateAt", columnDefinition = "DATETIME", nullable = true)
    protected LocalDateTime updateAt;

    public BaseEntity() {
        this.addAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
        this.isArchived = false;
        this.isDeleted = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAddAt() {
        return addAt;
    }

    public void setAddAt(LocalDateTime addAt) {
        this.addAt = addAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isIsArchived() {
        return isArchived;
    }

    public void setIsArchived(boolean isArchived) {
        this.isArchived = isArchived;
    }

}
