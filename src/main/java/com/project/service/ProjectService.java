package com.project.service;

import java.util.List;

import com.project.pojos.ProjectDetails;

public interface ProjectService 
{
	//add a method to insert project details
	String insertProjectDeatils(ProjectDetails projectDetails);
	
	//add a method to fetch all project details
	List<ProjectDetails> getAllProjectDetails();
	
	//add a method for updating project details
	ProjectDetails updateProjectDetails(Long id, ProjectDetails projectDetails);
	
	//add a method for deleting project details
	String deleteProjectDetails(Long id);
	
}
