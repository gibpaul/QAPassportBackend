package org.kainos.ea.resources;

import org.kainos.ea.cli.Application;
import org.kainos.ea.daos.ApplicationDAO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/application")
@Produces(MediaType.APPLICATION_JSON)
public class ApplicationResource {
    private final ApplicationDAO applicationDAO;

    public ApplicationResource(ApplicationDAO applicationDAO) {
        this.applicationDAO = applicationDAO;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response submitApplication(Application application) {
        applicationDAO.create(application);
        return Response.status(Response.Status.CREATED).entity(application).build();
    }
}
