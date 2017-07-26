package com.sc.agile.repository;

import com.sc.agile.model.Project;
import com.sc.agile.model.Task;
import io.katharsis.repository.RelationshipRepositoryBase;
import org.springframework.stereotype.Component;

@Component
public class ProjectToTaskRepository extends RelationshipRepositoryBase<Project, Long, Task, Long> {

    public ProjectToTaskRepository(){
        super(Project.class, Task.class);
    }

}
