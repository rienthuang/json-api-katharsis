package com.sc.agile.model;


import io.katharsis.resource.annotations.*;
import io.katharsis.resource.meta.MetaInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonApiResource(type="projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @JsonApiId
    private long projectId;
    private String projectName;
    @JsonApiRelation(opposite="project")
    private Task task;
}
