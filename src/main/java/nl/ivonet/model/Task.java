package nl.ivonet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Ivo Woltring
 */
public class Task {
    private final String task;
    private boolean done;
    private String reason;


    public Task(final String task) {
        this.task = task;
        this.done = task.contains("@done");
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(final String reason) {
        this.reason = reason;
    }

    public void setDone() {
        this.done = true;
        setReason("@done(" + LocalDateTime.now()
                                          .format(DateTimeFormatter.ISO_DATE) + ")");
    }
    public void setDone(final String reason) {
        this.done = true;
        setReason(reason);
    }

    public boolean isDone() {
        return this.done;
    }

    public String getTask() {
        return this.task;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Task{");
        sb.append("done=")
          .append(done);
        sb.append(", task='")
          .append(task)
          .append('\'');
        sb.append(", reason='")
          .append(reason)
          .append('\'');
        sb.append('}');
        return sb.toString();
    }
}
