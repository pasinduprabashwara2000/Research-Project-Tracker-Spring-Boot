package lk.ijse.cmjd.researchtracker.project.controller;

import lk.ijse.cmjd.researchtracker.project.DTO.ProjectDTO;
import lk.ijse.cmjd.researchtracker.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity <String> save(@RequestBody ProjectDTO projectDTO){
        try {
            projectService.save(projectDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Project Saved Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <String> update(@PathVariable String id, @RequestBody ProjectDTO projectDTO){
        try {
            projectService.update(id,projectDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Project Updated Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("{/id}")
    public ResponseEntity <String> delete(@PathVariable String id){
        try {
            projectService.delete(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Project Deleted Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("{/id}")
    public ResponseEntity <?> search(@PathVariable String id){
        try {
            ProjectDTO projectDTO = projectService.search(id);
            return ResponseEntity.ok(projectDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity <?> getAll(){
        try {
            ArrayList <ProjectDTO> projectDTO = projectService.getAll();
            return ResponseEntity.ok(projectDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }


}
