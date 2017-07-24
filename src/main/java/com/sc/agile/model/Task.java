package com.sc.agile.model;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiIncludeByDefault;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonApiResource(type="tasks")
public class Task {
    @JsonApiId
    private long id;
    private String name;
    @JsonApiRelation(opposite = "tasks")
    private Project project;
}
