package org.kainos.ea.api;

import java.sql.SQLException;

import org.kainos.ea.cli.Application;
import org.kainos.ea.client.FailedToCreateApplicationException;
import org.kainos.ea.daos.ApplicationDAO;

public class ApplicationService {
    private final ApplicationDAO applicationDao = new ApplicationDAO();

    public int createApplication(Application application) throws FailedToCreateApplicationException {
        try {
            int id = applicationDao.createApplication(application);

            if (id == -1) {
                throw new FailedToCreateApplicationException();
            }

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateApplicationException();
        }
    }
}
