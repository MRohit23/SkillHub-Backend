package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ProjectDao;
import com.project.pojos.ProjectDetails;

@Service
public class ProjectServiceImpl implements ProjectService
{
	@Autowired
	private ProjectDao projectDao;

	@Transactional
	@Override
	public String insertProjectDeatils(ProjectDetails projectDetails) 
	{
		
		ProjectDetails pd = projectDao.save(projectDetails);
		return "project Details added successfully" + pd.getId();
	}

	@Override
	public List<ProjectDetails> getAllProjectDetails() 
	{
		return projectDao.findAll();

	}

	@Override
	public ProjectDetails updateProjectDetails(Long id, ProjectDetails projectDetails) 
	{
		if(projectDao.existsById(id))
		{
			projectDetails.setId(id);
			projectDao.save(projectDetails);
		}

		return projectDetails;
	}

	@Override
	public String deleteProjectDetails(Long id) 
	{
		if(projectDao.existsById(id))
		{
			projectDao.deleteById(id);
			return "deleted successfully";
		}


		return "not deleted";
	}
	
	

	
	
	
}
