package lk.ijse.cmjd.researchtracker.project.service.secure.impl;

import lk.ijse.cmjd.researchtracker.project.DTO.secure.AuthRequest;
import lk.ijse.cmjd.researchtracker.project.DTO.secure.AuthResponse;
import lk.ijse.cmjd.researchtracker.project.security.JwtService;
import lk.ijse.cmjd.researchtracker.project.service.secure.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    @Override
    public AuthResponse login(AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()
                    )
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
            String token = jwtService.generateToken(String.valueOf(userDetails));

            return new AuthResponse(token);

        } catch (Exception e) {
            throw new Exception("Invalid Username or Password");
        }
    }
}
