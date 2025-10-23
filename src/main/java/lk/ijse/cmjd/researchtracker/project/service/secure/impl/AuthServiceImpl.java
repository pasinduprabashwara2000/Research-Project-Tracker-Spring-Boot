package lk.ijse.cmjd.researchtracker.project.service.secure.impl;

import lk.ijse.cmjd.researchtracker.project.DAO.UserDAO;
import lk.ijse.cmjd.researchtracker.project.DTO.secure.AuthRequest;
import lk.ijse.cmjd.researchtracker.project.DTO.secure.AuthResponse;
import lk.ijse.cmjd.researchtracker.project.DTO.secure.SignUpRequest;
import lk.ijse.cmjd.researchtracker.project.entity.UserEntity;
import lk.ijse.cmjd.researchtracker.project.security.JwtService;
import lk.ijse.cmjd.researchtracker.project.service.secure.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

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
            String token = jwtService.generateToken(userDetails.getUsername(), userDetails.getAuthorities().toString());

            return new AuthResponse(userDetails.getUsername(), userDetails.getAuthorities().toString(), token);

        } catch (Exception e) {
            throw new Exception("Invalid Username or Password");
        }
    }

    @Override
    public AuthResponse signup(SignUpRequest signUpRequest) throws Exception {
        if (userDAO.existsByUsername(signUpRequest.getUsername())) {
            throw new Exception("Username already taken");
        }

        UserEntity newUser = UserEntity.builder()
                .username(signUpRequest.getUsername())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .fullName(signUpRequest.getFullName())
                .role(signUpRequest.getRole() != null ? signUpRequest.getRole() : "USER")
                .createdAt(new Date())
                .build();

        userDAO.save(newUser);

        String token = jwtService.generateToken(newUser.getUsername(), newUser.getRole());

        return new AuthResponse(newUser.getUsername(), newUser.getRole(), token);
    }
}
