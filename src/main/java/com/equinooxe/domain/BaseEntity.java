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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

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

}
