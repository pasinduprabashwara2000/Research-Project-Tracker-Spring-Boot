package lk.ijse.cmjd.researchtracker.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.cmjd.researchtracker.project.Enum.ProjectStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "Project")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectEntity {

    @Id
    private String id;
    private String title;
    private String summary;
    private ProjectStatusEnum projectStatusEnum;
    private String pi;
    private String tags;
    private Date startDate;
    private Date endDate;
    private Date createdAt;
    private Date updatedAt;

}
