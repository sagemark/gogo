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
  * 127.0.0.1 peer1 (Run peer1 profile: -Dspring.profiles.active=peer1)
  * 127.0.0.1 peer2 (Run peer2 profile: -Dspring.profiles.active=peer2)
* Hit the following urls and see the respective peer references as replica
  * http://localhost:8761
  * http://localhost:8762
  
Eureka Client
* Dependency
  * Eureka Discovery
* Clients registered with the Eureka server
  * [Client 1](https://github.com/sagemark/gogo/blob/master/spring-microservices-eureka-server/spring-microservices-eureka-client/src/main/java/com/oreilly/cloud/SpringMicroservicesEurekaClientApplication.java)
  * [Client 2](https://github.com/sagemark/gogo/blob/master/spring-microservices-eureka-server/spring-microservices-eureka-client-2/src/main/java/com/oreilly/cloud/SpringMicroservicesEurekaClient2Application.java)
* Configuration
  * Add [@EnableEurekaClient](https://github.com/sagemark/gogo/blob/master/spring-microservices-eureka-server/spring-microservices-eureka-client/src/main/java/com/oreilly/cloud/SpringMicroservicesEurekaClientApplication.java#L11) annotation
  * Add [app name and default zone](https://github.com/sagemark/gogo/blob/master/spring-microservices-eureka-server/spring-microservices-eureka-client/src/main/resources/application.properties#L1)
  * Add [http://localhost:8888/serviceinfo](https://github.com/sagemark/gogo/blob/master/spring-microservices-eureka-server/spring-microservices-eureka-client-2/src/main/java/com/oreilly/cloud/SpringMicroservicesEurekaClient2Application.java#L20) request mapping that uses EurekaClient
  * Create [http://localhost:8080/execute](https://github.com/sagemark/gogo/blob/master/spring-microservices-eureka-server/spring-microservices-eureka-client/src/main/java/com/oreilly/cloud/ExampleController.java#L14) mapping that accesses other registered client through service name.
  
Hystrix Server
* Dependencies
  * Hystrix
  * Hystrix Dashboard
  * Web
  * Actuator
* Add [@EnableHystrix and @EnableHystrixDashboard](https://github.com/sagemark/gogo/blob/master/spring-microservices-simple-service/spring-microservices-hystrix/src/main/java/com/oreilly/cloud/SpringMicroservicesHystrixApplication.java#L23) annotations
* Create [@RequestMapping](https://github.com/sagemark/gogo/blob/master/spring-microservices-simple-service/spring-microservices-hystrix/src/main/java/com/oreilly/cloud/SpringMicroservicesHystrixApplication.java#L35) that sends call to a [simple microservice](https://github.com/sagemark/gogo/blob/master/spring-microservices-simple-service/src/main/java/com/oreilly/cloud/SpringMicroservicesSimpleServiceApplication.java#L15). Failover method and timeout configured.
* Check out [wiki](https://github.com/Netflix/Hystrix/wiki/Configuration) for other configuration options
* Access Hystrix dashboard at http://localhost:8080/hystrix and input http://localhost:8080/hystrix.stream into the input field

Ribbon
* Dependencies
  * Ribbon
  * Web
* Annotate with [@RibbonClient](https://github.com/sagemark/gogo/blob/master/spring-microservices-simple-service-2/spring-microservices-ribbon/src/main/java/com/oreilly/cloud/SpringMicroservicesRibbonApplication.java#L15) and give name to service
* Set up [@RequestMapping](https://github.com/sagemark/gogo/blob/master/spring-microservices-simple-service-2/spring-microservices-ribbon/src/main/java/com/oreilly/cloud/SpringMicroservicesRibbonApplication.java#L29) that uses name specified above (in this case "simple-service-2" as the load balanced domain)
* [Required Configuration](https://github.com/sagemark/gogo/blob/master/spring-microservices-simple-service-2/spring-microservices-ribbon/src/main/java/com/oreilly/cloud/SimpleServiceConfiguration.java) for ribbon client
* [application.properties](https://github.com/sagemark/gogo/blob/master/spring-microservices-simple-service-2/spring-microservices-ribbon/src/main/resources/application.properties#L1) edits including all the servers that will be load balanced
