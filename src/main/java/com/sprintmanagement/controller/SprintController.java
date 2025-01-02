package com.sprintmanagement.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sprintmanagement.dto.ResponseDto;
import com.sprintmanagement.dto.TeamMemberDto;
import com.sprintmanagement.exception.StoryNotFoundException;
import com.sprintmanagement.exception.TeamMemberNotFoundException;
import com.sprintmanagement.model.Sprint;
import com.sprintmanagement.model.Story;
import com.sprintmanagement.service.SprintService;
import com.sprintmanagement.service.StoryService;

@RestController
@RequestMapping("/api")
public class SprintController {
	

	    @Autowired
	    private SprintService sprintService;
	    
	    @Autowired
	    private StoryService storyService;
	    
	    @GetMapping("/sprints")
	    public ResponseEntity<ResponseDto> getAllSprints(){
	    	
	    	List<Sprint> allSprints = sprintService.getAllSprints();
	    	return ResponseEntity.ok(new ResponseDto ("Fetched all sprints successfully", allSprints));
	    }
	    
	    @PostMapping("/sprint")
	    public ResponseEntity<ResponseDto> createSprint(@RequestBody Sprint sprint) {
	        Sprint createdSprint = sprintService.createSprint(sprint);
	        return ResponseEntity.ok(new ResponseDto("Sprint created successfully", createdSprint));
	    }
	    
	    @PostMapping("/story")
	    public ResponseEntity<ResponseDto> createStory(@RequestBody Story story) {
	    	Story createdStory = storyService.createStory(story);

	        return ResponseEntity.ok(new ResponseDto("story created successfully", createdStory));
	    	
	    }

	    @PutMapping("/sprint/{sprintId}")
	    public ResponseEntity<ResponseDto> updateSprint(@PathVariable UUID sprintId, @RequestBody Sprint sprint) {
	        Sprint updatedSprint = sprintService.updateSprint(sprintId, sprint);
	        return ResponseEntity.ok(new ResponseDto("Sprint updated successfully", updatedSprint));
	    }

	    @DeleteMapping("/sprint/{sprintId}")
	    public ResponseEntity<ResponseDto> deleteSprint(@PathVariable UUID sprintId) {
	        sprintService.deleteSprint(sprintId);
	        return ResponseEntity.ok(new ResponseDto("Sprint deleted successfully", null));
	    }

	    @GetMapping("/sprints/{sprintId}/stories")
	    public ResponseEntity<ResponseDto> getStoriesForSprint(@PathVariable UUID sprintId) {
	        List<Story> stories = sprintService.getStoriesForSprint(sprintId);
	        return ResponseEntity.ok(new ResponseDto("Stories fetched successfully", stories));
	    }

	    @PutMapping("/stories/{storyId}/status")
	    public ResponseEntity<ResponseDto> updateStoryStatus(@PathVariable UUID storyId, @RequestParam String status) {
	        Story updatedStory = sprintService.updateStoryStatus(storyId, status);
	        return ResponseEntity.ok(new ResponseDto("Story status updated successfully", updatedStory));
	    }
	    
	    @GetMapping("/stories/{storyId}")
	    public ResponseEntity<ResponseDto> getStoryById(@PathVariable UUID storyId) throws StoryNotFoundException {
	        Story story = storyService.getStoryById(storyId);
	        return ResponseEntity.ok(new ResponseDto("Story fetched successfully", story));
	    }


}
