# gogo
Cloud Config Server 
* Dependency
   * Cloud Server
* [Configuration](https://github.com/sagemark/gogo/blob/master/spring-microservices-config-server/src/main/resources/application.properties#L1)
* [@EnableConfigServer](https://github.com/sagemark/gogo/blob/master/spring-microservices-config-server/src/main/java/com/oreilly/cloud/SpringMicroservicesConfigServerApplication.java#L8) added to application 

Cloud Config Client
* Dependencies
  * Config Client
  * Web
  * Actuator
* [Configuration](https://github.com/sagemark/gogo/blob/master/spring-microservices-config-server/spring-microservices-config-client/src/main/resources/bootstrap.properties#L1) is bootstrap.properties (loaded earlier than application.properties)
