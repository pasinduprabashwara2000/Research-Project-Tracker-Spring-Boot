package lk.ijse.cmjd.researchtracker.project.DTO;

import lk.ijse.cmjd.researchtracker.project.Enum.UserRoleEnum;
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
    private UserRoleEnum userRoleEnum;
    private Date createdAt;

}
