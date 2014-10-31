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
        final String path = "/Volumes/Dropbox/Dropbox/Apps/Editorial/taskpapers/Application Engineer.taskpaper";
        return this.reader.read(path);

    }



}
