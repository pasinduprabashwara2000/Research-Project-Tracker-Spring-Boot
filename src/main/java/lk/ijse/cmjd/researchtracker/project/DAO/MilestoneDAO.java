package lk.ijse.cmjd.researchtracker.project.DAO;

import lk.ijse.cmjd.researchtracker.project.entity.MilestoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneDAO extends JpaRepository <MilestoneEntity, String> {
}
