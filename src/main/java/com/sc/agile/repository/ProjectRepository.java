package com.sc.agile.repository;

import com.sc.agile.database.DBSimulator;
import com.sc.agile.model.Project;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProjectRepository extends ResourceRepositoryBase<Project, Long>{

    private DBSimulator dbSimulator = new DBSimulator();

    private Map<Long, Project> projects;

    public ProjectRepository(){
        super(Project.class);
        projects = dbSimulator.getProjects();
    }

    @Override
    public synchronized <S extends Project> S save(S project) {
        projects.put(project.getProjectId(), project);
        return project;
    }

    @Override
    public synchronized Project findOne(Long id, QuerySpec querySpec){
        return projects.get(id);
    }

    @Override
    public synchronized ResourceList<Project> findAll(QuerySpec querySpec) {
        return querySpec.apply(projects.values());
    }
}
