package lk.ijse.cmjd.researchtracker.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.cmjd.researchtracker.project.Enum.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {

    @Id
    private String id;
    private String username;
    private String password;
    private String fullName;
    private UserRoleEnum userRoleEnum;
    private Date createdAt;

}
