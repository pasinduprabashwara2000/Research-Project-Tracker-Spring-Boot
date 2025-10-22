package lk.ijse.cmjd.researchtracker.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "Document")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DocumentEntity {

    @Id
    private String id;
    private String projectID;
    private String title;
    private String description;
    private String urlOrPath;
    private String uploadedBy;
    private Date uploadedAt;

}
