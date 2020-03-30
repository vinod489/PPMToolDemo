package com.fullstackdemo.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstackdemo.springbootdemo.domain.Project;
import com.fullstackdemo.springbootdemo.exceptions.ProjectIDException;
import com.fullstackdemo.springbootdemo.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		//logic - validations..etc..
		try {
			return projectRepository.save(project);
		} catch(Exception e) {
			throw new ProjectIDException("Unable to save project with project Id '"+project.getProjectIdentifier().toUpperCase()+"' due to "+e.getMessage());
		}
	}
	
	public Project findProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		if(project == null) {
			throw new ProjectIDException("Project ID '"+projectId+"' does not exist");
		}
		return project;
		
	}
	
	public Iterable<Project> findAllProjects() {
		return projectRepository.findAll();
	}
	
	public void deleteProject(String projectId) {
		Project project = findProjectByIdentifier(projectId);
		if(project != null) {
			projectRepository.delete(project);
		}
	}
}
