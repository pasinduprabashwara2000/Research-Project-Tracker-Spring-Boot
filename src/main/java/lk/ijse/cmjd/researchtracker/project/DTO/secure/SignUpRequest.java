package lk.ijse.cmjd.researchtracker.project.DTO.secure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SignUpRequest {

    private String username;
    private String password;
    private String fullName;
    private String role;

}
