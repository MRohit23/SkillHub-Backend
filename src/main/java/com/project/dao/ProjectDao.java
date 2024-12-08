package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.pojos.ProjectDetails;

@Repository
public interface ProjectDao extends JpaRepository<ProjectDetails, Long>
{
	
}
