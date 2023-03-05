# **Car-lease Platform API**

## Getting Started

Car-lease Platform Application is a micro service project based on Spring boot with various services like manage customers and the manage inventory system.

- This application has a service registry which is Eureka server and all the services are registered here  as a client.
- All the api requests go through the api gateway.
- There is a common port for all the services which is the gateway and this decides the resource based on configuration provided in application.yml file
- The gateway url is http://localhost/9100/
- You can use swagger ui to check all the services and the url is http://localhost:9100/swagger-ui/


### Technology used

- Java 11
- Spring boot with Microservice architecture
- Eureka server for service registry
- spring cloud gateway
- Spring JPA
- H2 Data base
- Junit 5

### Service Details

- **Auth service**

> This service is mainly to handle authentication and authorization. It
> has to api for login user and register user. Once the user is
> registered he can login through the same user name and password and
> this login api will generate a token and return the same token as
> response. User has to pass this token for all the api call in other
> services of this application.

- **Broker service**

> This service manage all the customer related data like Add, update, delete and find.

- **Cloud-gateway service**

> This service is the entry point of application so that user can run all the service using this api gateway. This service is the common point for swagger configuration and JWT authorization to avoid repetitive code in all service.

- **Inventory service**

This service manages all the Inventory data like Add, update, delete and find a vehicle.

-  **Registry service**

> Here i have used Eureka server to act as server and all other services are registered here as client.


### Steps to run the application

1.  Clone all modules from git repository

2. Execute below command for all the modules individually

    mvn clean install -DskipTests
    mvn spring-boot:run

3. Now you can run the application using swagger UI:
4. Open this url in any browser
http://localhost:9100/swagger-ui/


5. It will look like the below screen shot where you can find all the services in select a definition dropdown.

	**![](https://lh4.googleusercontent.com/3ouYO1DMnk-O6Ua5pLCTH_JGDJGAefw6lVLfxqaxdCDrWkyDjdeyLrDO_cAGupZwsntgpKSuuN3k1tFibG_y5lb0rfk6ZLtKq7DwgIOZ8gvsX-m3IaknAn2-w_as-Ja6XF5y_rpFeVSlhJ1Ba0Sk5A)**
  

6.  Default service is auth and in auth service first select register a user and then login user using same username and password. You will get a token like this:

	**![](https://lh3.googleusercontent.com/SS5mp2vy7Yij-bjZ3-Okb8WEdwL-8YlFWkMjAh4DSpYmnyqcO5bT3W0ixXk2G-udkUh1Y-YyStqUsvKoriYSVX_USoD21QNCYJO46AFolEbTWu39KI2i41r4uF2aLeekZNsGeOoupeEyfCEmr-wniQ)**

7.   Copy the above generated code and open broker service from the dropdown.
8.   Once you open broker service you can see a authorization symbol at the right side. This is for global authorization for this particular service. Click on the lock and paste the token and then Authorization.
**![](https://lh6.googleusercontent.com/rotnEObF55N7O1IFzdYzJDR0TX0d2o_prz8DcaZFq6dWI6N0zuPUWcjL51Y9Z1QwuCtn0Iwas4c6Kg_ZM1CVja-Tm5gF76dzHeVpd_PQlaC2KipyArqnlugogtBO20uy-kYYOSTs4AZa1FmvIdYXqg)**  
9.  Now you can run all the apis with this token and no need to provide individually.
10.  Same way you can test Inventory service.


## H2 database console details

-   User Database:  http://localhost:8181/h2-ui
	DB name -UserDB

-   Customer Database: http://localhost:7000/h2-ui
	DB name - CustomerDB

-   Inventory Database - http://localhost:7001/h2-ui
	DB name – InventoryDB

***Future Improvements***

 - [ ] Role based authentication and authorization.    
 - [ ] Containerisation of this application using Docker
 - [ ] Use of Authorization server for secret key
 - [ ] Secret key can be read from environment variable
 - [ ] Detail exception handling.
 - [ ] Email notification for various service.
