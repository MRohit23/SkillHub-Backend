package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pojos.ProjectDetails;
import com.project.service.ProjectService;


@Controller
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class ProjectController 
{
	@Autowired
	private ProjectService projectService;
	
	public ProjectController()
	{
		System.out.println("in project controller" + getClass());
	}
	
	
	@PostMapping
	public String insertProjectDeatils(@RequestBody ProjectDetails projectDetails)
	{
		System.out.println("add new category" + projectDetails);
		String result = projectService.insertProjectDeatils(projectDetails);
		
//		return ResponseEntity.status(HttpStatus.CREATED)
//				.body("project created successfully");
		
		return "redirect:/project/getAll";
		
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllProjectDetails()
	{
		System.out.println("get project details");
		List<ProjectDetails>  pd = projectService.getAllProjectDetails();
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(pd);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProjectDetails(@PathVariable Long id, @RequestBody ProjectDetails projectDetails)
	{
		System.out.println("updated Successfully" + id + projectDetails);
		try {
			return ResponseEntity.ok(projectService.updateProjectDetails(id, projectDetails));
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
		}
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProjectDetails(@PathVariable Long id)
	{
		System.out.println("deleted Successfully" + id);
		try {
			return ResponseEntity.ok(projectService.deleteProjectDetails(id));
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
		}
		
	}
}
