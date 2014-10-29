package nl.ivonet.controler;

import nl.ivonet.io.TaskPaperReader;
import nl.ivonet.model.TaskPaper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ivo Woltring
 */
@Path("/home")
@RequestScoped
public class HomeController {


    @Inject
    private TaskPaperReader reader;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TaskPaper get() {

        String path = "/Volumes/Dropbox/Dropbox/Apps/Editorial/taskpapers/Help.taskpaper";

        return this.reader.read(path);

//        final TaskPaper taskPaper = new TaskPaper();
//
//        taskPaper.add("A task without a topic");
//        final Task task = new Task("A Done task with a reason");
//        task.setDone();
//        taskPaper.add(task);
//        taskPaper.add("another task without a topic");
//
//        final Topic topic = new Topic("This is a topic");
//        topic.add("This is an item under topic");
//        taskPaper.addTopic(topic);
//
//        final Topic topic2 = new Topic("This is another topic");
//        topic2.add("This is an item under another topic");
//        topic2.add("This is an item under another topic");
//        topic2.add("This is an item under another topic");
//        topic2.add("This is an item under another topic");
//        taskPaper.addTopic(topic2);
//
//        return taskPaper;
    }

}
