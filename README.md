# Receipt Tax Calculator

## Built With

* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system 
* 	[Lombok](https://projectlombok.org/) - Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.
* 	[Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.

## To-Do

- [x] RESTful Web Service (CRUD's create method)
- [x] Client - Next.js (https://github.com/TMontenegro/taxcalculatorclient) 
      Obs: The client is hosted here https://taxcalculatorclient.vercel.app/ but, at the moment, the integration only works locally because the API is using HTTP and the client is using HTTPS.

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `br.com.montenegro.taxcalculator.TaxCalculatorApplication` class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

### URLs

|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:8080/api/checkout`                           | POST | Custom Response Headers|


## Documentation

* [Swagger](http://taxcalculator-env-1.eba-dfnvacpx.us-east-1.elasticbeanstalk.com/swagger-ui.html) - Documentation & Testing

## Files and Directories

The project (a.k.a. project directory) has a particular directory structure. A representative project is shown below:

```
.
├── Spring Elements
├── src
│   └── main
│       └── java
│           ├── br.com.montenegro.taxcalculator.constants
│           ├── br.com.montenegro.taxcalculator.controllers
│           ├── br.com.montenegro.taxcalculator.entities
│           ├── br.com.montenegro.taxcalculator.services
│           ├── br.com.montenegro.taxcalculator.swagger
│           └── br.com.montenegro.taxcalculator.utils
├── src
│   └── main
│       └── resources
│           └── static
├── src
│   └── test
│       └── java
├── JRE System Library
├── Referenced Libraries
├── Maven Dependencies
├── src
├── target
│   └──application-0.0.1-SNAPSHOT
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## packages

- `constants` — to hold our constants;
- `controllers` — to listen to the client;
- `entities` — to hold our entities;
- `exceptions` — to hold our exceptions;
- `services` — to hold our business logic;
- `swagger` — to document and test our API;
- `utils` — to hold our helper code;
- `test/` - contains unit tests
- `pom.xml` - contains all the project dependencies
