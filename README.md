## springboot-crud-application

A Springboot-Cassandra-Java application built using maven as a build tool. 
This application has all the CRUD oprations and some other methods that uses [Supported query keywords](https://docs.spring.io/spring-data/couchbase/docs/current/reference/html/#repository-query-keywords).

[Lombok](https://projectlombok.org/) is also used to reduce a lot of boilerplate code.

Steps to run the application:
1. Download and run Cassandra before running the application.
2. [Using the Maven Plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-running-your-application.html#using-boot-running-with-the-maven-plugin): The Spring Boot Maven plugin includes a run goal that can be used to quickly compile and run your application. Maven command to run a Spring Boot application:
       
   <code>mvn spring-boot:run</code>
3. Now, you can hit the service for the following endpoints:
   1. Welcome page: <code>localhost:8082</code>
   2. Add user: <code>localhost:8082user/add</code>
      
      Request Body: 
          
        {
          "id": "1",
          "name: "Knoldus",
          "age": "7"
          }
   3. Get user by id: <code>localhost:8082/1</code>
   4. Update user: <code>localhost:8082/user/update/1/knoldus/8</code>
   5. Count users by name: <code>localhost:8082/user/count/knoldus</code>
   6. Get user by using two params: <code>localhost:8082/user/getbynameandage/knoldus/8</code>
   7. Delete user: <code>localhost:8082/user/delete/1</code>
   
