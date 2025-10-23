package lk.ijse.cmjd.researchtracker.project.controller;

import lk.ijse.cmjd.researchtracker.project.DTO.UserDTO;
import lk.ijse.cmjd.researchtracker.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/user/")
@RequiredArgsConstructor
public class UserController {

    final private UserService userService;

    @PreAuthorize("hasRole('Admin')")
    @PostMapping
    public ResponseEntity <String> save(@RequestBody UserDTO userDTO) throws Exception {
        try {
            userService.save(userDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("User Saved Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('Admin')")
    @PutMapping("/{id}")
    public ResponseEntity <String> update(@PathVariable String id, @RequestBody UserDTO userDTO) throws Exception {
        try {
            userService.update(id,userDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("User Updated Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity <String> delete(@PathVariable String id) throws Exception {
        try {
            userService.delete(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("User Deleted Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/{id}")
    public ResponseEntity <?> search(@PathVariable String id) throws Exception {
        try {
            UserDTO userDTO = userService.search(id);
            return ResponseEntity.ok(userDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('Admin')")
    @GetMapping
    public ResponseEntity <?> getAll() throws Exception {
        try {
            ArrayList <UserDTO> userDTOS = userService.getAll();
            return ResponseEntity.ok(userDTOS);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

}
