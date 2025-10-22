package lk.ijse.cmjd.researchtracker.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MilestoneDTO {

    private String id;
    private String projectID;
    private String title;
    private String description;
    private Date dueDate;
    private boolean isCompleted;
    private String createdBy;

}
