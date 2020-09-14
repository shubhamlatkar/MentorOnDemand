[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/shubhamlatkar/mentor-on-demand-backend)
[![Spring Spring-Boot](https://img.shields.io/badge/Spring-Spring_boot-green?logo=spring)](https://start.spring.io/)
[![MongoDb Database](https://img.shields.io/badge/MongoDB-Database-47A248?logo=mongodb)](https://cloud.mongodb.com/)
[![Intellij Intellij-idea](https://img.shields.io/badge/Intellij-Intellij_idea-black?logo=intellij-idea)](https://www.jetbrains.com/idea/)


# MentorOnDemand #
Mentor On Demand Architecture diagram.
[![Mentor-On-Demand.png](https://i.postimg.cc/gj92K8WG/Mentor-On-Demand.png)](https://postimg.cc/0Mfvk6j4)
  
It is a full stack web app designed using the ReactJS for front-end adn spring-boot microservices as a backend.

Front-end UI designed using ReactJS in another repo [here](https://github.com/shubhamlatkar/react-redux-thunk/tree/master/src/Mentor-on-demand).
  
 
There are various spring-boot microservices as:-
  1. user-service -> Maintains all the data and functions for user, trainer, admin.
  2. course-service -> Maintains all the data and functions of courses.
  3. user-course -> Maintains all the functions and data of user specific course details.
  4. eureka-server -> Server for all the microservices
  5. api-gateway -> Gateway for all the microservices implementing spring security using the JWT.
  6. auth-service -> Maintains all authentication related endpoints.
  7. config-server -> Provides the configuration from the git repo to all microservices.
  8. hystrix-dashboard -> Hystrix monitoring for the microservices.
  9. kafka-event-bus -> Kafka and zookeeper running in docker-compose container.

