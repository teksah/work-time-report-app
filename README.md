# Work Time Report App

Small web-app using crud operation.
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


Then, you can then access application here: [http://localhost:8080/](http://localhost:8080/)<br><br>

## Sign in
By default, there are 3 users: 2 with user role and 1 with admin role

username: antoni - password: antoni - with USER role <br> 
username: jaroslaw - password: jaroslaw - with USER role
<br><br>
username: admin - password: admin - with ADMIN role




## Built With

* Spring Boot 2
* Spring Framework 5
* Maven

## Authors

* Sebastian Bakowski
