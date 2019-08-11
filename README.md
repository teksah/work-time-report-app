# Work Time Report App

Small web-app using crud operation. Application was created to organize work reports in the company.<br>Still under construction...


### Installing
You can build a jar file and run it from the command line:
```
git clone https://github.com/teksah/work-time-report-app.git
cd work-time-report-app
./mvnw package
java -jar report-app-web/target/*jar
```

You can then access application here: [http://localhost:8080/](http://localhost:8080/)

Or you can run it from Maven directly using the Spring Boot Maven plugin.

```
./mvnw install && ./mvnw spring-boot:run -pl report-app-web
```


## Built With

* Spring Boot 2
* Spring Framework 5
* Maven

## Authors

* Sebastian Bakowski
