package com.sc.agile.database;

import com.sc.agile.model.Project;
import com.sc.agile.model.Task;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

        Task t1 = new Task(1, "Get Glass Tank", p1);
        Task t2 = new Task(2, "Stock Regal Angel", p1);
        Task t3 = new Task(3, "Buy Protein Skimmer", p1);
        Task t4 = new Task(4, "Break into Microservice Architecture", p2);
        Task t5 = new Task(5, "Code Bus Uncle for Echo", p3);

        ArrayList<Task> tasks1 = new ArrayList<>();
        ArrayList<Task> tasks2 = new ArrayList<>();
        ArrayList<Task> tasks3 = new ArrayList<>();

        tasks1.add(t1);
        tasks1.add(t2);
        tasks1.add(t3);
        tasks2.add(t4);
        tasks3.add(t5);

        p1.setTasks(tasks1);
        p2.setTasks(tasks2);
        p3.setTasks(tasks3);

        tasks.put(1L, t1);
        tasks.put(2L, t2);
        tasks.put(3L, t3);
        tasks.put(4L, t4);
        tasks.put(5L, t5);

        projects.put(1L, p1);
        projects.put(2L, p2);
        projects.put(3L, p3);
    }
}
