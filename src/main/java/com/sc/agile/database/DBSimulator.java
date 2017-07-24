package com.sc.agile.database;

import com.sc.agile.model.Project;
import com.sc.agile.model.Task;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class DBSimulator {
    private Map<Long, Task> tasks;
    private Map<Long, Project> projects;

    public DBSimulator(){
        tasks = new HashMap<>();
        projects = new HashMap<>();

        Project p1 = new Project(1L, "Aquarium Project", null);
        Project p2 = new Project(2L, "Reporting Dashboard", null);
        Project p3 = new Project(3L, "Amazon Alexa", null);

        tasks.put(1L, new Task(1, "Get Glass Tank", p1));
        tasks.put(2L, new Task(2, "Stock Regal Angel", p1));
        tasks.put(3L, new Task(3, "Buy Protein Skimmer", p1));
        tasks.put(4L, new Task(4, "Break into Microservice Architecture", p2));
        tasks.put(5L, new Task(5, "Code Bus Uncle for Echo", p3));

        projects.put(1L, p1);
        projects.put(2L, p2);
        projects.put(3L, p3);
    }
}
