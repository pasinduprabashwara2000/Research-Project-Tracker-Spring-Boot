package lk.ijse.cmjd.researchtracker.project.entity;

import lk.ijse.cmjd.researchtracker.project.Enum.ProjectStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectEntity {

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
