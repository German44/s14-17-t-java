package com.domain.projects;

import org.springframework.data.jpa.repository.JpaRepository;
import com.domain.projects.Projects;

public interface ProjectsRepository extends JpaRepository<Projects, Long> {
    
}
