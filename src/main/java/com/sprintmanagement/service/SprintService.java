package com.sprintmanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintmanagement.exception.ResourceNotFoundException;
import com.sprintmanagement.model.Sprint;
import com.sprintmanagement.model.Story;
import com.sprintmanagement.repo.SprintRepository;
import com.sprintmanagement.repo.StoryRepository;

@Service
public class SprintService {
	
	@Autowired
	private SprintRepository sprintRepository;
	
	@Autowired
	private StoryRepository storyRepository;
	
	public Sprint createSprint(Sprint sprint) {
		return sprintRepository.save(sprint);
	}
	
	public Sprint updateSprint(UUID sprintId, Sprint updatedSprint) {
		
		Sprint sprint = sprintRepository.findById(sprintId)
				.orElseThrow(() -> new ResourceNotFoundException("Sprint not found with id " + sprintId));
		
		sprint.setName(updatedSprint.getName());
		sprint.setStartDate(updatedSprint.getStartDate());
		sprint.setEndDate(updatedSprint.getEndDate());
		sprint.setVelocity(updatedSprint.getVelocity());
		sprint.setStatus(updatedSprint.getStatus());
		
		return sprintRepository.save(sprint);

	}
	
	public void deleteSprint(UUID sprintId) {
		
		Sprint sprint = sprintRepository.findById(sprintId)
				.orElseThrow(() -> new ResourceNotFoundException("Sprint not found with id " + sprintId));
		
		sprintRepository.delete(sprint);
	}
	
	public List<Story> getStoriesForSprint(UUID sprintId ) {
		
		Sprint sprint = sprintRepository.findById(sprintId)
				.orElseThrow(() -> new ResourceNotFoundException("Sprint not found with id " + sprintId));
		
		return sprint.getStories();
	}
	
	public Story updateStoryStatus(UUID storyId, String status) {
		
		Story story = storyRepository.findById(storyId)
				.orElseThrow(() -> new ResourceNotFoundException("Story not found with id " + storyId));
		
		story.setStatus(status);
		
		return storyRepository.save(story);
	}
	
	public List<Sprint> getAllSprints() {
		
		return sprintRepository.findAll();
	}
	
	public Sprint getSprintById(UUID sprintId) {
        Optional<Sprint> sprint = sprintRepository.findById(sprintId);
        return sprint.orElse(null); 
    }
	
	
	
	

}
