package com.fullstackdemo.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstackdemo.springbootdemo.domain.Project;
import com.fullstackdemo.springbootdemo.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		//logic - validations..etc..
		return projectRepository.save(project);
	}
}
