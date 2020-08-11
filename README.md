[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/shubhamlatkar/mentor-on-demand-backend)
[![Spring Spring-Boot](https://img.shields.io/badge/Spring-Spring_boot-green?logo=spring)](https://start.spring.io/)
[![MongoDb Database](https://img.shields.io/badge/MongoDB-Database-47A248?logo=mongodb)](https://cloud.mongodb.com/)
[![Intellij Intellij-idea](https://img.shields.io/badge/Intellij-Intellij_idea-black?logo=intellij-idea)](https://www.jetbrains.com/idea/)


# MentorOnDemand #
Mentor On Demand 
  
It is a full stack web app designed using the ReactJS for front-end adn spring-boot microservices as a backend.

Front-end UI designed using ReactJS in another repo [here](https://github.com/shubhamlatkar/react-redux-thunk/tree/master/src/Mentor-on-demand).
  
 
There are various spring-boot microservices as:-
  1. user-service -> Maintains all the data and functions for user, trainer, admin.
  2. course-service -> Maintains all the data and functions of courses.
  3. user-course -> Maintains all the functions and data of user specific course details.
  4. eureka-server -> Server for all the microservices
  5. api-gateway -> Gateway for all the microservices implementing spring security using the JWT.


### In order to run the microservices don't forget to add following properties for all microservices:-

- server port
- spring application name
- eureka service-url
- eureka hostname=localhost
- mongodb uri
- jwt secret 
