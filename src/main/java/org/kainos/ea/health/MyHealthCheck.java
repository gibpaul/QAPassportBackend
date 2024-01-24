package org.kainos.ea.health;
import com.codahale.metrics.health.HealthCheck;
import org.kainos.ea.db.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class MyHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        // Perform health check logic here
        boolean databaseStatus = checkDatabase();

        if (!databaseStatus) {
            return Result.unhealthy("Health-check Failed!");
        }

        return Result.healthy();
    }

    private boolean checkDatabase() {
        try {
            Connection connection = DatabaseConnector.getConnection();
            // Check if the database connection is valid
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            // Log or handle the exception as needed
            System.err.println("Database connection check failed: " + e.getMessage());
            return false;
        }
    }
}
