package com.sprintmanagement.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintmanagement.model.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, UUID> {

}
