package com.sc.agile.repository;

import com.sc.agile.database.DBSimulator;
import com.sc.agile.model.Task;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TaskRepository extends ResourceRepositoryBase<Task, Long> {

    @Autowired
    private DBSimulator dbSimulator = new DBSimulator();

    private Map<Long, Task> tasks;

    public TaskRepository(){
        super(Task.class);
        tasks = dbSimulator.getTasks();
    }

    public synchronized <S extends Task> S save(S task) {
        tasks.put(task.getId(), task);
        return task;
    }

    public Task findOne(Long id, QuerySpec querySpec){
        return tasks.get(id);
    }

    @Override
    public synchronized ResourceList<Task> findAll(QuerySpec querySpec) {
        return querySpec.apply(tasks.values());
    }

}
