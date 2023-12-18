package org.kainos.ea;

import com.codahale.metrics.MetricRegistry;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.kainos.ea.resources.PassportController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class trueApplication extends Application<trueConfiguration> {

    public static void main(final String[] args) throws Exception {
        new trueApplication().run(args);

        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        dataSourceFactory.setDriverClass("org.postgresql.Driver");
        dataSourceFactory.setUser("userpg");
        dataSourceFactory.setPassword("password");
        dataSourceFactory.setUrl("jdbc:postgresql://localhost:5432/academyfrontend");

        DataSource dataSource = dataSourceFactory.build(new MetricRegistry(), "postgresql");
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to PostgreSQL database!");
        } catch (SQLException e) {
            System.err.println("Unable to connect to PostgreSQL database!");
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "true";
    }

    @Override
    public void initialize(final Bootstrap<trueConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final trueConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new PassportController());
    }

}
