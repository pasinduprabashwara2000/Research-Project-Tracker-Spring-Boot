package lk.ijse.cmjd.researchtracker.project.service.impl;

import lk.ijse.cmjd.researchtracker.project.DAO.ProjectDAO;
import lk.ijse.cmjd.researchtracker.project.DTO.ProjectDTO;
import lk.ijse.cmjd.researchtracker.project.entity.ProjectEntity;
import lk.ijse.cmjd.researchtracker.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDAO projectDAO;

    @Override
    public void save(ProjectDTO projectDTO) throws Exception {
        try {
            ProjectEntity projectEntity = new ProjectEntity(
                    projectDTO.getId(),
                    projectDTO.getTitle(),
                    projectDTO.getSummary(),
                    projectDTO.getProjectStatusEnum(),
                    projectDTO.getPi(),
                    projectDTO.getTags(),
                    projectDTO.getStartDate(),
                    projectDTO.getEndDate(),
                    projectDTO.getCreatedAt(),
                    projectDTO.getUpdatedAt()
            );
            projectDAO.save(projectEntity);
        } catch (Exception e) {
            throw new Exception("Project Saved Failed : " + e.getMessage());
        }

    }

    @Override
    public void update(String id, ProjectDTO projectDTO) throws Exception {

        Optional<ProjectEntity> projectExists = projectDAO.findById(id);

        try {
            if (projectExists.isPresent()) {
                ProjectEntity projectEntity = projectExists.get();
                projectEntity.setTitle(projectDTO.getTitle());
                projectEntity.setSummary(projectDTO.getSummary());
                projectEntity.setProjectStatusEnum(projectDTO.getProjectStatusEnum());
                projectEntity.setPi(projectDTO.getPi());
                projectEntity.setTags(projectDTO.getTags());
                projectEntity.setStartDate(projectDTO.getStartDate());
                projectEntity.setEndDate(projectDTO.getEndDate());
                projectEntity.setCreatedAt(projectDTO.getCreatedAt());
                projectEntity.setUpdatedAt(projectDTO.getUpdatedAt());
                projectDAO.save(projectEntity);
            } else {
                throw new Exception("Project with " + id + " not found");
            }
        } catch (Exception e) {
            throw new Exception("Error Updating project : " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            if (projectDAO.existsById(id)) {
                projectDAO.deleteById(id);
            } else {
                throw new Exception("Project with " + id + " not found");
            }
        } catch (Exception e) {
            throw new Exception("Error Deleting project " + e.getMessage());
        }
    }

    @Override
    public ProjectDTO search(String id) throws Exception {

        Optional<ProjectEntity> projectExists = projectDAO.findById(id);

        try {
            if (projectExists.isPresent()) {
                ProjectEntity projectEntity = projectExists.get();
                return new ProjectDTO(
                        projectEntity.getId(),
                        projectEntity.getTitle(),
                        projectEntity.getSummary(),
                        projectEntity.getProjectStatusEnum(),
                        projectEntity.getPi(),
                        projectEntity.getTags(),
                        projectEntity.getStartDate(),
                        projectEntity.getEndDate(),
                        projectEntity.getCreatedAt(),
                        projectEntity.getUpdatedAt()
                );
            } else {
                throw new Exception("Project with " + id + " not found");
            }
        } catch (Exception e) {
            throw new Exception("Error Finding Project : " + e.getMessage());
        }

    }

        @Override
        public ArrayList<ProjectDTO> getAll () throws Exception {
            try {
                List <ProjectEntity> projectEntities = projectDAO.findAll();
                ArrayList <ProjectDTO> projectDTOS = new ArrayList<>();
                for (ProjectEntity projectEntity : projectEntities){
                    projectDTOS.add(new ProjectDTO(
                            projectEntity.getId(),
                            projectEntity.getTitle(),
                            projectEntity.getSummary(),
                            projectEntity.getProjectStatusEnum(),
                            projectEntity.getPi(),
                            projectEntity.getTags(),
                            projectEntity.getStartDate(),
                            projectEntity.getEndDate(),
                            projectEntity.getCreatedAt(),
                            projectEntity.getUpdatedAt()
                    ));
                }
                return projectDTOS;
            } catch (Exception e) {
                throw new Exception("Can't Retrieve Data : "+e.getMessage());
            }
        }

}
