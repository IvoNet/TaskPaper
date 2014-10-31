package nl.ivonet.model;

/**
 *
 * @author Ivo Woltring
 */
public class Task {
    private final String task;


    public Task(final String task) {
        this.task = task;
    }


    public boolean isDone() {
        return this.task.contains("@done");
    }

    public String getTask() {
        return this.task;
    }


}
