package lk.ijse.cmjd.researchtracker.project.service;

import lk.ijse.cmjd.researchtracker.project.DTO.MilestoneDTO;
import java.util.ArrayList;

public interface MilestoneService {

    void save(MilestoneDTO milestoneDTO) throws Exception;
    void update(String id, MilestoneDTO milestoneDTO) throws Exception;
    void delete(String id) throws Exception;
    MilestoneDTO search() throws Exception;
    ArrayList <MilestoneDTO> getAll() throws Exception;

}
