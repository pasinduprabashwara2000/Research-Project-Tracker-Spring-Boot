package lk.ijse.cmjd.researchtracker.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MilestoneEntity {

    private String id;
    private String project;
    private String title;
    private String description;
    private Date dueDate;
    private boolean isCompleted;
    private String createdBy;

}
