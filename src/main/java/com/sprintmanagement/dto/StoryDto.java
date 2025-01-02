package com.sprintmanagement.dto;

import java.util.UUID;

public class StoryDto {
	
	private UUID id;
	
	private String name;
    
    private String description;
    
    private int storyPoints;

	private String status;
    
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
	
	public StoryDto(UUID id, String name, String description, int storyPoints, String status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.storyPoints = storyPoints;
		this.status = status;
	}
	

}
