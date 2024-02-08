package org.kainos.ea.service;

import java.sql.SQLException;

import org.kainos.ea.cli.Application;
import org.kainos.ea.exception.FailedToCreateApplicationException;
import org.kainos.ea.daos.ApplicationDao;
import org.kainos.ea.util.DatabaseConnector;

public class ApplicationService {
    public ApplicationDao applicationDao;
    public DatabaseConnector databaseConnector;

    public ApplicationService(ApplicationDao applicationDao, DatabaseConnector databaseConnector) {
        this.applicationDao = applicationDao;
        this.databaseConnector = databaseConnector;
    }

    public int createApplication(Application application) throws FailedToCreateApplicationException {
        try {
//
//             add validation step here
//
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
