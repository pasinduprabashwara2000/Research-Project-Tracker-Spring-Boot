package lk.ijse.cmjd.researchtracker.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private String id;
    private String username;
    private String password;
    private String fullName;
    private String role;
    private Date createdAt;

}
