package com.example.ruvimProject.DTO;

import lombok.*;

import java.util.Date;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProjectEntityDTO {
    private Integer project_id;
    private String porject_name;
    private String description;
    private Date start_date;
    private Date deadline;
    private Integer user_id;
}
