package lk.ijse.cmjd.researchtracker.project.controller;

import lk.ijse.cmjd.researchtracker.project.DTO.DocumentDTO;
import lk.ijse.cmjd.researchtracker.project.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/document/")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping
    public ResponseEntity <String> save(@RequestBody DocumentDTO documentDTO) throws Exception {
        try {
            documentService.save(documentDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Document Saved Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <String> update(@PathVariable String id, @RequestBody DocumentDTO documentDTO){
        try {
            documentService.update(id,documentDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Document Update Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <String> delete(@PathVariable String id) throws Exception{
        try {
            documentService.delete(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Document Deleted Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity <?> search(@PathVariable String id) throws Exception {
        try {
            DocumentDTO documentDTO = documentService.search(id);
            return ResponseEntity.ok(documentDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity <?> getAll() {
        try {
            ArrayList <DocumentDTO> documentDTOS = documentService.getAll();
            return ResponseEntity.ok(documentDTOS);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Can't Retrieve Data : "+e.getMessage());
        }
    }
 }
