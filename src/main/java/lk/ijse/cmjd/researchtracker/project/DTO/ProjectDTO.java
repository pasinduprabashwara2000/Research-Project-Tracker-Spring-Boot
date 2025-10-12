package lk.ijse.cmjd.researchtracker.project.dto;

import lk.ijse.cmjd.researchtracker.project.dto.Enum.ProjectStatusEnum;

import java.util.Date;

public class ProjectDTO {

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
