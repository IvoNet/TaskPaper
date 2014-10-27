package nl.ivonet.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivo Woltring
 */
public class Topic {
    private final String title;
    private final List<Task> tasks;

    public Topic(final String title) {
        this.title = title;
        this.tasks = new ArrayList<>();
    }

    public void add(final String task) {
        this.tasks.add(new Task(task));
    }

    public void add(final Task task) {
        this.tasks.add(task);

    }

    public String getTitle() {
        return this.title;
    }

    public List<Task> getTasks() {
        return this.tasks;
    }
}
