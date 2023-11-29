package com.example.ruvimProject.DTO.DTO_convector;

import com.example.ruvimProject.DTO.ProjectEntityDTO;
import com.example.ruvimProject.modell.ProjectEntity;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
public class ProjectEntityDTOConvector {
    public ProjectEntityDTO convectorToDTO(ProjectEntity projectEntity){
        ProjectEntityDTO projectEntityDTO = ProjectEntityDTO.builder()
                .project_id(projectEntity.getProject_id())
                .porject_name(projectEntity.getProject_name())
                .description(projectEntity.getDescription())
                .start_date(projectEntity.getStart_date())
                .deadline(projectEntity.getDeadline())
                .user_id(projectEntity.getUser().getId())
                .build();
        return projectEntityDTO;
    }

    public ProjectEntity convectorToModell(ProjectEntityDTO projectEntityDTO){

    }
}
