package org.kainos.ea.controller;

import io.swagger.annotations.Api;
import org.kainos.ea.service.ApplicationService;
import org.kainos.ea.cli.Application;
import org.kainos.ea.cli.ApplicationWrapper;
import org.kainos.ea.exception.FailedToCreateApplicationException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("QA Academy Passport Application API")
@Path("/api")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @POST
    @Path("/application")
    @Produces(MediaType.APPLICATION_JSON)
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
