package lk.ijse.cmjd.researchtracker.project.dao;

import lk.ijse.cmjd.researchtracker.project.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentDAO extends JpaRepository <DocumentEntity, String> {
}
