package com.fullstackdemo.springbootdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackdemo.springbootdemo.domain.Project;
import com.fullstackdemo.springbootdemo.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/")
	public ResponseEntity<Project> saveProject(@RequestBody Project project) {
		Project savedProject = projectService.saveOrUpdateProject(project);
		return new ResponseEntity<Project>(savedProject, HttpStatus.CREATED);
	}	
}
