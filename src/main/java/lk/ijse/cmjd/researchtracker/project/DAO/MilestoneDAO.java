package lk.ijse.cmjd.researchtracker.project.dao;

import lk.ijse.cmjd.researchtracker.project.entity.MilestoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneDAO extends JpaRepository <MilestoneEntity, String> {
}
