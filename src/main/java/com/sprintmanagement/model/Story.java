package com.sprintmanagement.model;


import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public class Story {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	private String name;
	
	private String description;
	
	private int storyPoints;
	
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "sprint_id", nullable = false)
	@JsonBackReference
	private Sprint sprint;
	
	@Column(name = "team_member_id")
	private UUID assignedTo;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public UUID getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(UUID assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Story() {
		super();
	}
	
	
	
	

	
}
