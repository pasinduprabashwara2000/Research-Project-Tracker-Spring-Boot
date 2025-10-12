package lk.ijse.cmjd.researchtracker.project.DAO;

import lk.ijse.cmjd.researchtracker.project.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentDAO extends JpaRepository <DocumentEntity, String> {
}
