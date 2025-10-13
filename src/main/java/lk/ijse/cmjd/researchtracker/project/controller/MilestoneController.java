package lk.ijse.cmjd.researchtracker.project.controller;

import lk.ijse.cmjd.researchtracker.project.DTO.MilestoneDTO;
import lk.ijse.cmjd.researchtracker.project.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MilestoneController {

    private final MilestoneService milestoneService;

    @PostMapping
    public ResponseEntity <String> save(@RequestBody MilestoneDTO milestoneDTO){
        try {
            milestoneService.save(milestoneDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Milestone Saved Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity <String> update(@PathVariable String id, @RequestBody MilestoneDTO milestoneDTO){
        try {
            milestoneService.update(id,milestoneDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Milestone Updated Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

}
