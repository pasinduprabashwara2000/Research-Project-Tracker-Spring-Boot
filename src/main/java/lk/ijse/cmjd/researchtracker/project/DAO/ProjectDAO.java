package lk.ijse.cmjd.researchtracker.project.DAO;

import lk.ijse.cmjd.researchtracker.project.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDAO extends JpaRepository <ProjectEntity, String> {
}
