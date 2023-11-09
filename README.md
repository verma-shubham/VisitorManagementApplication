# VisitorManagementApp

## Development

Update your local database connection in `application.properties` or create your own `application-local.properties` file to override
settings for development.

During development it is recommended to use the profile `local`. In IntelliJ `-Dspring.profiles.active=local` can be
added in the VM options of the Run Configuration after enabling this property in "Modify options".

Lombok must be supported by your IDE. For IntelliJ install the Lombok plugin and enable annotation processing -
[learn more](https://bootify.io/next-steps/spring-boot-with-lombok.html).

After starting the application it is accessible under `localhost:8080`.

## Build

The application can be built using the following command:

```
mvnw clean package
```

Start your application with the following command - here with the profile `production`:

```
java -Dspring.profiles.active=production -jar ./target/visitor-management-app-0.0.1-SNAPSHOT.jar
```

If required, a Docker image can be created with the Spring Boot plugin. Add `SPRING_PROFILES_ACTIVE=production` as
environment variable when running the container.

```
mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=io.bootify/visitor-management-app
```

For Quick onboarding(... in a nutshell):

1-edit below details in application.properties file with your database details:
spring.datasource.url=jdbc:mysql://localhost:3306/<anyName>
spring.datasource.username=root
spring.datasource.password=<yourPassword>

2-create a database <anyName> in your DB.

3-do maven clean - build the application. Run 'VisitorManagementAppApplication'.

4-explore the database schema created via hibernate

5-To access the RESt APIs add details of users (or atleast one ADMIN which can create different kind of users via APIs)
encode your desired password using any online available BCrypt generator(ref:https://www.browserling.com/tools/bcrypt)
(ex: password abc@123 -> $2a$10$6Kvgb.mhq5qT3jygCJFSjO/cdt5R0AKutILNXOQijW6ulk53h8HCO)
adding users:-
INSERT INTO USER VALUES(1,now(), 'abc@gmail.com',now(), 'Alok', '$2a$10$6Kvgb.mhq5qT3jygCJFSjO/cdt5R0AKutILNXOQijW6ulk53h8HCO',7524895726,'ADMIN','ACTIVE',null,null);
INSERT INTO USER VALUES(24,now(), 'xyz@gmail.com',now(), 'Amir', '$2a$10$GqqJwgnWGPYOd04OFDiGaeLyNBWomtOfi86mtTDr89grgg8KZSoqO',9752489508,'RESIDENT','ACTIVE',null,null);
INSERT INTO USER VALUES(17,now(), 'qaz@gmail.com',now(), 'Aman', '$2a$10$/kLxoLSJMX1OWl7KTtIeRe2dHhSVXhHE9WiL4uUkjsI9oCXWoihJ2',9786352322,'GATEKEEPER','ACTIVE',null,null);

Visit http://localhost:8080/swagger-ui/index.html

Thankyou!