package com.equinooxe.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.elasticsearch.search.aggregations.support.format.ValueFormat.DateTime;

import com.equinooxe.domain.util.LocalDateTimeDeserializer;
import com.equinooxe.domain.util.LocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.querydsl.core.types.dsl.DateTemplate;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Notification {
	public static final String ERROR_TYPE="ERROR";
	public static final String INFO_TYPE="INFO";
	public static final String WARNING_TYPE="WARNING";
	public static final String SUCCESS_TYPE="SUCCESS";
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
	
	@Column(unique = false, columnDefinition = "TEXT")
	private String message;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "type" )
	private String type;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(name = "addAt", columnDefinition = "DATETIME")
    protected LocalDateTime addAt=LocalDateTime.now();
	
	public Notification(){
		this.addAt = LocalDateTime.now();
	}
	
	public Notification(String message, String title) {
		super();
		this.message = message;
		this.title = title;
		this.type = INFO_TYPE;
		this.addAt = LocalDateTime.now();
	}

	public Notification(String message, String title, String type) {
		super();
		this.message = message;
		this.title = title;
		this.type = type;
		this.addAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getAddAt() {
		return addAt;
	}

	public void setAddAt(LocalDateTime addAt) {
		this.addAt = addAt;
	}
	
}
