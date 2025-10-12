package lk.ijse.cmjd.researchtracker.project.service;

import lk.ijse.cmjd.researchtracker.project.DTO.ProjectDTO;
import java.util.ArrayList;

public interface ProjectService {

    void save(ProjectDTO projectDTO) throws Exception;
    void update(String id, ProjectDTO projectDTO) throws Exception;
    void delete(String id) throws Exception;
    ProjectDTO search(String id) throws Exception;
    ArrayList <ProjectDTO> getAll() throws Exception;

}
