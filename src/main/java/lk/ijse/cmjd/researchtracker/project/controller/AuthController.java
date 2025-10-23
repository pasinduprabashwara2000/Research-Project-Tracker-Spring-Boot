package lk.ijse.cmjd.researchtracker.project.controller;

import lk.ijse.cmjd.researchtracker.project.DTO.secure.AuthRequest;
import lk.ijse.cmjd.researchtracker.project.DTO.secure.AuthResponse;
import lk.ijse.cmjd.researchtracker.project.DTO.secure.SignUpRequest;
import lk.ijse.cmjd.researchtracker.project.service.secure.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) throws Exception {
        return ResponseEntity.ok(authService.login(authRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignUpRequest signUpRequest) throws Exception {
        return ResponseEntity.ok(authService.signup(signUpRequest));
    }

}
