package com.example.ruvimProject.repository;

import com.example.ruvimProject.modell.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<ProjectEntity, Integer> {
}
