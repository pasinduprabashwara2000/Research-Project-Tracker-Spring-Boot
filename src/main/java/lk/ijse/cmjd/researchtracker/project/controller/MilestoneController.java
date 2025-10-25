package lk.ijse.cmjd.researchtracker.project.controller;

import lk.ijse.cmjd.researchtracker.project.DTO.MilestoneDTO;
import lk.ijse.cmjd.researchtracker.project.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/milestone/")
@RequiredArgsConstructor
public class MilestoneController {

    private final MilestoneService milestoneService;

    @PreAuthorize("hasRole('Admin') or hasRole('Member')")
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

    @PreAuthorize("hasRole('Admin') or hasRole('Member')")
    @PutMapping("/{id}")
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

    @PreAuthorize("hasRole('Admin') or hasRole('Member')")
    @DeleteMapping("/{id}")
    public ResponseEntity <String> delete(@PathVariable String id) throws Exception {
        try {
            milestoneService.delete(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Milestone Deleted Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('Admin') or hasRole('Member')")
    @GetMapping("/{id}")
    public ResponseEntity <?> search(@PathVariable String id) throws Exception {
        try {
            MilestoneDTO milestoneDTO = milestoneService.search(id);
            return ResponseEntity.ok(milestoneDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('Admin') or hasRole('Member')")
    @GetMapping
    public ResponseEntity <?> getAll(){
        try {
            ArrayList <MilestoneDTO> milestoneDTOS = milestoneService.getAll();
            return ResponseEntity.ok(milestoneDTOS);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
