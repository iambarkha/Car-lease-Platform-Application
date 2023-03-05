# Car-lease-Platform-Application
Getting Started
  Car-lease Platform Application is a microservice project based on Spring boot with various services like manage customers and the manage inventory system.

**Technology used-** 

	- Java 11
  
	- Spring boot with Microservice architecture
  
	- Ereka server for service registry
  
	- spring cloud gateway
  
	- Spring JPA
  
	- H2 Data base
  
	- Junit 5
  
  **Detail description:** 
  
   - This application has a service registry which is Eureka server and all the services are registered here  as a client.
   - All the api requests go through the api gateway.
   - There is a common port for all the services which is the gateway and this decides the resource based on configuration provided in application.yml file
   - The gateway url is http://localhost/9100/ 
   - You can use swagger ui to check all the services and the url is http://localhost:9100/swagger-ui/
  
  
