package lk.ijse.cmjd.researchtracker.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "Milestone")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MilestoneEntity {

    @Id
    private String id;
    private String project;
    private String title;
    private String description;
    private Date dueDate;
    private boolean isCompleted;
    private String createdBy;

}
