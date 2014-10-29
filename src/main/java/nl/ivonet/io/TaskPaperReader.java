package nl.ivonet.io;

import nl.ivonet.model.TaskPaper;
import nl.ivonet.model.Topic;

import javax.ejb.Stateless;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Ivo Woltring
 */
@Stateless
public class TaskPaperReader {


    public String removeAccents(final String text) {
        return (text == null) ? null : Normalizer.normalize(text, Normalizer.Form.NFD)
                                                 .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }


    public List<String> listFromFilename(final String filename) {
//        final String location = TaskPaperReader.class.getResource(filename)
//                                                     .toExternalForm();
        try (final InputStreamReader in = new InputStreamReader(new FileInputStream(filename));
             final BufferedReader br = new BufferedReader(in)) {
            return br.lines()
                     .parallel()
                     .filter(p -> !p.isEmpty())
                     .collect(Collectors.toList());
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }


    public TaskPaper read(final String filename) {

        final List<String> items = listFromFilename(filename);

        final TaskPaper taskPaper = new TaskPaper();
        final Stream<String> stream = items.stream();
        stream.filter(s -> s.startsWith("-"))
              .forEach(taskPaper::add);

        taskPaper.getTasks()
                 .stream()
                 .forEach(p -> System.out.println("p = " + p.getTask()));

        Topic topic = null;
        for (final String line : items) {
            if (line.startsWith("-")) {
                taskPaper.add(line);
            } else if (line.endsWith(":")) {
                topic = new Topic(line);
                taskPaper.addTopic(topic);
            } else if (topic != null) {
                topic.add(line);
            }
        }

        return taskPaper;
    }


}
