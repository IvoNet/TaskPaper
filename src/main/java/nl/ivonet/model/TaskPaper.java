package nl.ivonet.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivo Woltring
 */
@XmlRootElement
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
}
