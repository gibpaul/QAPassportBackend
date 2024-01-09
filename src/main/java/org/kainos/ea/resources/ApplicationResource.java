package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.ApplicationService;
import org.kainos.ea.cli.Application;
import org.kainos.ea.cli.ApplicationWrapper;
import org.kainos.ea.client.FailedToCreateApplicationException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("QA Academy Passport Application API")
@Path("/application")
@Produces(MediaType.APPLICATION_JSON)
public class ApplicationResource {
    private final ApplicationService applicationService = new ApplicationService();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response submitApplication(ApplicationWrapper applicationWrapper) {
        try {
            Application application = applicationWrapper.getApplication();
            return Response.ok(applicationService.createApplication(application)).build();
        } catch (FailedToCreateApplicationException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}
