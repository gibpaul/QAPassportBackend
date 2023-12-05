package org.kainos.ea.resources;


import org.kainos.ea.api.PassportService;
import org.kainos.ea.cli.Passport;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class PassportController {
    private PassportService passportService = new PassportService();
    @GET
    @Path("/passports")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Passport> getPassports() {
        return passportService.getAllPassports();
    }
}
