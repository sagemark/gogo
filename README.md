# gogo
Cloud Config Server 
* Dependency
   * Cloud Server
* [Configuration](https://github.com/sagemark/gogo/blob/master/spring-microservices-config-server/src/main/resources/application.properties#L1)
* [@EnableConfigServer](https://github.com/sagemark/gogo/blob/master/spring-microservices-config-server/src/main/java/com/oreilly/cloud/SpringMicroservicesConfigServerApplication.java#L8) added to application 
* Assuming Java Crypto Jars are installed AND an encrypt.key is set in application.properties, you can POST to server for encrypting and decrypting values
  * http://localhost:8888/encrypt
  * http://localhost:8888/decrypt
  * encrypted values are stored in [client-config-development.properties](https://github.com/sagemark/cloud-config/blob/master/client-config-development.properties#L1)

Cloud Config Client
* Dependencies
  * Config Client
  * Web
  * Actuator
* [Configuration](https://github.com/sagemark/gogo/blob/master/spring-microservices-config-server/spring-microservices-config-client/src/main/resources/bootstrap.properties#L1) is bootstrap.properties (loaded earlier than application.properties)
  * Had to set management.security.enabled=false to http://localhost:8080/refresh actuator endpoint could be hit
    * Update Config Repo
    * Hit /refresh endpoint
    * This works because  [@RefreshScope](https://github.com/sagemark/gogo/blob/master/spring-microservices-config-server/spring-microservices-config-client/src/main/java/com/oreilly/cloud/SpringMicroservicesConfigClientApplication.java#L11) was added to the client application8761
    
Eureka Server
* Dependency
  * Eureka Server
* Add [@EnableEurekaServer](https://github.com/sagemark/gogo/blob/master/spring-microservices-eureka-server/src/main/java/com/oreilly/cloud/SpringMicroservicesEurekaServerApplication.java#L9) annotation
* Configure [server 1](https://github.com/sagemark/gogo/blob/master/spring-microservices-eureka-server/src/main/resources/application-peer1.properties#L1) and [server 2](https://github.com/sagemark/gogo/blob/master/spring-microservices-eureka-server/src/main/resources/application-peer2.properties#L1)
* Ensure the following entries are in hosts file
  * 127.0.0.1 peer1
  * 127.0.0.1 peer2
* Hit the following urls and see the respective peer references as replica
  * http://localhost:8761
  * http://localhost:8762
  
Eureka Client
* Dependency
  * Eureka Discovery
* Configuration
  * Add [@EnableEurekaClient](https://github.com/sagemark/gogo/blob/master/spring-microservices-eureka-server/spring-microservices-eureka-client/src/main/java/com/oreilly/cloud/SpringMicroservicesEurekaClientApplication.java#L11) annotation
  * Add [app name and default zone](https://github.com/sagemark/gogo/blob/master/spring-microservices-eureka-server/spring-microservices-eureka-client/src/main/resources/application.properties#L1)
  * Add [http://localhost:8888/serviceinfo](https://github.com/sagemark/gogo/blob/master/spring-microservices-eureka-server/spring-microservices-eureka-client-2/src/main/java/com/oreilly/cloud/SpringMicroservicesEurekaClient2Application.java#L20) request mapping that uses EurekaClient
  * Create [http://localhost:8080/execute](https://github.com/sagemark/gogo/blob/master/spring-microservices-eureka-server/spring-microservices-eureka-client/src/main/java/com/oreilly/cloud/ExampleController.java#L14) mapping that accesses other registered client through service name.
