package lk.ijse.cmjd.researchtracker.project.service.secure;

import lk.ijse.cmjd.researchtracker.project.DTO.secure.AuthRequest;
import lk.ijse.cmjd.researchtracker.project.DTO.secure.AuthResponse;

public interface AuthService {

    AuthResponse login(AuthRequest authRequest) throws Exception;

}
