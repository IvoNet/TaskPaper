package nl.ivonet.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivo Woltring
 */
public class TaskPaper {

    private final List<Task> tasks;
    private final List<Topic> topics;

    public TaskPaper() {
        this.tasks = new ArrayList<>();
        this.topics = new ArrayList<>();
    }

    public void addTopic(final Topic topic) {
        this.topics.add(topic);
    }

    public void add(final String task) {
        this.tasks.add(new Task(task));
    }

    public void add(final Task task) {
        this.tasks.add(task);
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public List<Topic> getTopics() {
        return this.topics;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TaskPaper{");
        sb.append("tasks=")
          .append(tasks);
        sb.append(", topics=")
          .append(topics);
        sb.append('}');
        return sb.toString();
    }
}
