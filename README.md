# true

How to start the true application
---

1. Run `psql -U [YOUR_POSTGRES_USERNAME] -d passport_prototype -a -f CreateDatabase.sql` to create the database.
2. Run `mvn clean install` to build your application
3. Start application with `java -jar target/QAPassportBackend-1.0-SNAPSHOT.jar server config.yml`
4. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your application's health enter url `http://localhost:8081/healthcheck`
