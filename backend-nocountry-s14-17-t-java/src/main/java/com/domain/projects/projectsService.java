package com.domain.projects;

import java.util.List;
import com.dto.ProjectsModel;

public interface ProjectsService {

    ProjectsModel createprojects(ProjectsModel projectsModel);
    ProjectsModel updateprojects(Long projectsId, ProjectsModel projectsModel);

    ProjectsModel getprojectsById(Long id);
    List<ProjectsModel> getAllprojects();

    void deleteprojects(Long projectsId);
}
