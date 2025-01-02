package com.sprintmanagement.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintmanagement.model.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, UUID>{

}
