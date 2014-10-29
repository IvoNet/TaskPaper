package nl.ivonet.io;

import nl.ivonet.model.TaskPaper;
import nl.ivonet.model.Topic;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

public class TaskPaperReaderTest {

    private TaskPaperReader reader;

    @Before
    public void setUp() throws Exception {
        this.reader = new TaskPaperReader();
    }

    @Test
    public void testName() throws Exception {
        final List<String> strings = this.reader.listFromFilename("Todo.txt");

        final TaskPaper taskPaper = new TaskPaper();
        final Stream<String> stream = strings.stream();
        stream.filter(s -> s.startsWith("-"))
              .forEach(taskPaper::add);

        taskPaper.getTasks()
                 .stream()
                 .forEach(p -> System.out.println("p = " + p.getTask()));

        Topic topic = null;
        for (final String line : strings) {
            if (line.startsWith("-")) {
                taskPaper.add(line);
            } else if (line.endsWith(":")) {
                topic = new Topic(line);
                taskPaper.addTopic(topic);
            } else if (topic != null) {
                topic.add(line);
            }
        }

        System.out.println("taskPaper = " + taskPaper);


    }
}