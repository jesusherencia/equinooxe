package com.equinooxe.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.equinooxe.domain.util.LocalDateTimeDeserializer;
import com.equinooxe.domain.util.LocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


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
	private String title="";
	
	@Column(name = "type", nullable=true )
	private String type=INFO_TYPE;
	
	@Column(name = "url", nullable=true)
	private String url="#";
	
	@ManyToOne(targetEntity=User.class)
	private User user;
	
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(name = "addAt", columnDefinition = "DATETIME")
    protected LocalDateTime addAt=LocalDateTime.now();
	
	public Notification(){
		this.addAt = LocalDateTime.now();
	}
	
	public Notification(User user,String message, String title, String url) {
		super();
		this.user=user;
		this.message = message;
		this.title = title;
		this.url=url;
		this.type = INFO_TYPE;
		this.addAt = LocalDateTime.now();
	}

	public Notification(User user,String message, String title, String url, String type) {
		super();
		this.user=user;
		this.message = message;
		this.title = title;
		this.url=url;
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
	
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	@Override
	public String toString() {
		return "Notification [id=" + id + ", message=" + message + ", title=" + title + ", type=" + type + ", url="
				+ url + ", user=" + user.toString() + ", addAt=" + addAt + "]";
	}
	
	
}
