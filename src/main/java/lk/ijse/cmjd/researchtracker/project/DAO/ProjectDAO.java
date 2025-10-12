package lk.ijse.cmjd.researchtracker.project.dao;

import lk.ijse.cmjd.researchtracker.project.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDAO extends JpaRepository <ProjectEntity, String> {
}
