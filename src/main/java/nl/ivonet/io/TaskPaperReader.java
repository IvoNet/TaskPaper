package nl.ivonet.io;

import nl.ivonet.model.TaskPaper;
import nl.ivonet.model.Topic;

import javax.ejb.Stateless;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;

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


    public TaskPaper read(final String filename) {

        try (final InputStreamReader in = new InputStreamReader(new FileInputStream(filename));
             final BufferedReader br = new BufferedReader(in)) {

            final TaskPaper taskPaper = new TaskPaper();

            br.lines()
              .filter(p -> !(p.isEmpty() || "\n\r\t".contains(p)))
              .forEach(new TaskPaperReader.StringConsumer(taskPaper)::convert);

            return taskPaper;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

    }


    private static class StringConsumer  {
        private final TaskPaper taskPaper;
        Topic topic;

        public StringConsumer(final TaskPaper taskPaper) {
            this.taskPaper = taskPaper;
        }

        public void convert(final String line) {
            if (line.startsWith("-")) {
                this.taskPaper.add(line);
            } else if (line.endsWith(":") && !line.matches("^[ \\t]*-.*:")) {
                this.topic = new Topic(line);
                this.taskPaper.addTopic(this.topic);
            } else if (this.topic != null) {
                this.topic.add(line);
            }

        }
    }
}
