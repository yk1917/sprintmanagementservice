package com.sprintmanagement.repo;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sprintmanagement.dto.TeamMemberDto;

@FeignClient(name = "TeammanagementService")
public interface TeamManagementClient {
	
	@GetMapping("/teams/members/{id}")
	ResponseEntity<TeamMemberDto> getTeamMembersById(@PathVariable UUID id);
	

}
