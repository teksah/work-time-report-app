# Work Time Report App

Small web-app using crud operation. Originally application was developed to organize work reports in the company I've worked.
Now, it is use as a demonstration app for my for future employers, hoping to get a job as a junior programmer. :-)
<br>
<br>
The project is still in development.


### Installing
You can build a jar file and run it from the command line:
```
git clone https://github.com/teksah/work-time-report-app.git
cd work-time-report-app
./mvnw package
java -jar report-app-web/target/*jar
```
Or you can run it from Maven directly using the Spring Boot Maven plugin.

```
./mvnw install && ./mvnw spring-boot:run -pl report-app-web
```


Then, you can then access application here: [http://localhost:8080/](http://localhost:8080/)<br>
With credentials USERNAME: antoni - PASSWORD: antoni




## Built With

* Spring Boot 2
* Spring Framework 5
* Maven

## Authors

* Sebastian Bakowski
