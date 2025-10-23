package lk.ijse.cmjd.researchtracker.project.service.secure;

import lk.ijse.cmjd.researchtracker.project.DTO.secure.AuthRequest;
import lk.ijse.cmjd.researchtracker.project.DTO.secure.AuthResponse;
import lk.ijse.cmjd.researchtracker.project.DTO.secure.SignUpRequest;

public interface AuthService {

    AuthResponse login(AuthRequest authRequest) throws Exception;
    AuthResponse signup(SignUpRequest signUpRequest) throws Exception;

}
