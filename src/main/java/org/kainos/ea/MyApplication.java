package org.kainos.ea;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.kainos.ea.cli.Address;
import org.kainos.ea.cli.Applicant;
import org.kainos.ea.cli.ApplicantType;
import org.kainos.ea.cli.ApplicationType;
import org.kainos.ea.cli.DCSThreatLevel;
import org.kainos.ea.cli.Delivery;
import org.kainos.ea.cli.FacialImage;
import org.kainos.ea.cli.Gender;
import org.kainos.ea.cli.IcaoComplianceResult;
import org.kainos.ea.cli.Medium;
import org.kainos.ea.cli.Name;
import org.kainos.ea.cli.Nationality;
import org.kainos.ea.cli.Passport;
import org.kainos.ea.cli.PaymentDetails;
import org.kainos.ea.cli.PreviousPassports;
import org.kainos.ea.cli.Product;
import org.kainos.ea.cli.ServiceLevel;
import org.kainos.ea.daos.ApplicationDAO;
import org.kainos.ea.resources.ApplicationResource;
import org.w3c.dom.DocumentType;

public class MyApplication extends Application<MyConfiguration> {
    private final HibernateBundle<MyConfiguration> hibernateBundle = new HibernateBundle<MyConfiguration>(
            Address.class,
            Applicant.class,
            ApplicantType.class,
            Application.class,
            ApplicationType.class,
            DCSThreatLevel.class,
            Delivery.class,
            DocumentType.class,
            FacialImage.class,
            Gender.class,
            IcaoComplianceResult.class,
            Medium.class,
            Name.class,
            Nationality.class,
            Passport.class,
            PaymentDetails.class,
            PreviousPassports.class,
            Product.class,
            ServiceLevel.class
        ) {
        @Override
        public DataSourceFactory getDataSourceFactory(MyConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    public static void main(final String[] args) throws Exception {
        new MyApplication().run(args);
    }

    @Override
    public String getName() {
        return "true";
    }

    @Override
    public void initialize(final Bootstrap<MyConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final MyConfiguration configuration, final Environment environment) {
        final ApplicationDAO applicationDAO = new ApplicationDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new ApplicationResource(applicationDAO));
    }
}
