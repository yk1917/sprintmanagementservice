package com.sprintmanagement.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprintmanagement.dto.TeamMemberDto;
import com.sprintmanagement.exception.StoryNotFoundException;
import com.sprintmanagement.exception.TeamMemberNotFoundException;
import com.sprintmanagement.model.Story;
import com.sprintmanagement.repo.StoryRepository;
import com.sprintmanagement.repo.TeamManagementClient;

@Service
public class StoryService {
	
	@Autowired
	private StoryRepository storyRepository;
	
	public Story createStory(Story story) {
		return storyRepository.save(story);
	}
//	
//	@Autowired
//	private TeamManagementClient teamManagementClient;
	
//	
	public Story getStoryById(UUID storyId) throws StoryNotFoundException {
        return storyRepository.findById(storyId).orElseThrow(() -> new StoryNotFoundException("Story with ID " + storyId + " not found"));
    }
	
//	public TeamMemberDto getAssignedTeamMember(UUID teamMemberId) throws TeamMemberNotFoundException {
//	    ResponseEntity<TeamMemberDto> response = teamManagementClient.getTeamMembersById(teamMemberId);
//
//	    if (response.getStatusCode() == HttpStatus.OK) {
//	        return response.getBody();
//	    } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
//	        throw new TeamMemberNotFoundException("Team Member with ID " + teamMemberId + " not found.");
//	    } else {
//	        throw new RuntimeException("Unexpected response from Team Management Service");
//	    }
//	}
//	
	
	
	
}

	
	
	


