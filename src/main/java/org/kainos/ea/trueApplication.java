package org.kainos.ea;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.kainos.ea.health.MyHealthCheck;
import org.kainos.ea.resources.ApplicationResource;

public class trueApplication extends Application<trueConfiguration> {

    public static void main(final String[] args) throws Exception {
        new trueApplication().run(args);
    }

    @Override
    public String getName() {
        return "true";
    }

    @Override
    public void initialize(final Bootstrap<trueConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(trueConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }

    @Override
    public void run(final trueConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new ApplicationResource());
        final MyHealthCheck healthCheck = new MyHealthCheck();
        environment.healthChecks().register("my-health-check", healthCheck);
    }
}
