package lk.ijse.cmjd.researchtracker.project.service.impl;

import lk.ijse.cmjd.researchtracker.project.DAO.MilestoneDAO;
import lk.ijse.cmjd.researchtracker.project.DTO.MilestoneDTO;
import lk.ijse.cmjd.researchtracker.project.entity.MilestoneEntity;
import lk.ijse.cmjd.researchtracker.project.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MilestoneServiceImpl implements MilestoneService {

    private final MilestoneDAO milestoneDAO;

    @Override
    public void save(MilestoneDTO milestoneDTO) throws Exception {
        try {
            MilestoneEntity milestoneEntity = new MilestoneEntity(
                    milestoneDTO.getId(),
                    milestoneDTO.getProject(),
                    milestoneDTO.getTitle(),
                    milestoneDTO.getDescription(),
                    milestoneDTO.getDueDate(),
                    milestoneDTO.isCompleted(),
                    milestoneDTO.getCreatedBy()
            );
            milestoneDAO.save(milestoneEntity);
        } catch (Exception e) {
            throw new Exception("Milestone Saved Failed : "+e.getMessage());
        }
    }

    @Override
    public void update(String id, MilestoneDTO milestoneDTO) throws Exception {

        Optional <MilestoneEntity> milestoneExists = milestoneDAO.findById(id);

        try {
            if(milestoneExists.isPresent()){
                MilestoneEntity milestoneEntity = milestoneExists.get();
                milestoneEntity.getProject();
                milestoneEntity.getTitle();
                milestoneEntity.getDescription();
                milestoneEntity.getDueDate();
                milestoneEntity.isCompleted();
                milestoneEntity.getCreatedBy();
                milestoneDAO.save(milestoneEntity);
            } else {
                throw new Exception("Milestone with "+id+" not found");
            }
        } catch (Exception e) {
            throw new Exception("Milestone Update Failed : "+e.getMessage());
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            if(milestoneDAO.existsById(id)){
                milestoneDAO.deleteById(id);
            } else {
                throw new Exception("Milestone with "+id+" not found");
            }
        } catch (Exception e) {
            throw new Exception("Milestone Deleted Failed");
        }
    }

    @Override
    public MilestoneDTO search(String id) throws Exception {
        Optional <MilestoneEntity> milestoneExists = milestoneDAO.findById(id);

        try {
            if (milestoneExists.isPresent()) {
                MilestoneEntity milestoneEntity = milestoneExists.get();
                return new MilestoneDTO(
                        milestoneEntity.getId(),
                        milestoneEntity.getProject(),
                        milestoneEntity.getTitle(),
                        milestoneEntity.getDescription(),
                        milestoneEntity.getDueDate(),
                        milestoneEntity.isCompleted(),
                        milestoneEntity.getCreatedBy()
                );
            } else {
                throw new Exception("Milestone with " + id + " not found");
            }
        } catch (Exception e) {
            throw new Exception("Error finding Milestone : "+e.getMessage());
        }
    }

    @Override
    public ArrayList<MilestoneDTO> getAll() throws Exception {

        try {
            List<MilestoneEntity> milestoneEntities = milestoneDAO.findAll();
            ArrayList<MilestoneDTO> milestoneDTOS = new ArrayList<>();
            for (MilestoneEntity milestoneEntity : milestoneEntities) {
                milestoneDTOS.add(new MilestoneDTO(
                        milestoneEntity.getId(),
                        milestoneEntity.getProject(),
                        milestoneEntity.getTitle(),
                        milestoneEntity.getDescription(),
                        milestoneEntity.getDueDate(),
                        milestoneEntity.isCompleted(),
                        milestoneEntity.getCreatedBy()
                ));
            }

            return milestoneDTOS;
        } catch (Exception e) {
            throw new Exception("Can't Retrieve Data : "+e.getMessage());
        }
    }
}
