# Development Continues

* It is not the final state
* Authority control structure is currently being developed

---

## What this repository for?
This project microservice architecture implementation trying on spring cloud ecosystem.

### Used Spring Cloud Modules
* Config Server
* Eureka Server
* Spring Cloud Gateway
* Spring Cloud Load Balancer
* Hystrix
* Admin Panel
* Zipkin

---

# Requirements

* <b> JDK 17 </b>
* <b> Maven </b>
* <b> Rabbit MQ Server </b> : Available in docker-compose file.
* <b> Zipkin Server </b>    : Available in docker-compose file. Just start the server to trace (Default Port: 9411)
* <b> Build Dependencies In Order Of Writing </b>  

  | Dependency Or Parent                                        | Description                                                  | Repository                                                   |         
  |-------------------------------------------------------------|--------------------------------------------------------------|--------------------------------------------------------------|
  |  <font color="orange"> **coc-cloud-top-parent** </font>     | Pom should be exist in .m2 local folder. (mvn clean install) | https://github.com/erensayar/common-components               |
  |  <font color="orange"> **coc-cloud-parent** </font>         | Pom should be exist in .m2 local folder. (mvn clean install) | https://github.com/erensayar/common-components               |
  |  <font color="orange"> **coc-core** </font>                 | Jar should be exist in .m2 local folder. (mvn clean install) | https://github.com/erensayar/common-components               |
  |  <font color="orange"> **msparent** </font>                 | Pom should be exist in .m2 local folder. (mvn clean install) | In this Repo                                                 |
  |  <font color="orange"> **mscore** </font>                   | Jar should be exist in .m2 local folder. (mvn clean install) | In this Repo                                                 |
  |  <font color="orange"> **coc-boot-parent** </font>          | Jar should be exist in .m2 local folder. (mvn clean install) | https://github.com/erensayar/common-components               |
  |  <font color="orange"> **coc-auth** </font>                 | Jar should be exist in .m2 local folder. (mvn clean install) | https://github.com/erensayar/common-components               |

# Architecture

![Architecture](dev-docs/images/ss-arch.png)

# Working Principle

![WorkingPrinciple](dev-docs/images/ss-purpose-and-query-structure.png)

# Auth Structure For Ms App

![WorkingPrinciple](dev-docs/images/authStructureForMsApp.png)


# Logic

![Logic](dev-docs/images/ss-logic.png)

# Entities Look Like These

![Entities](dev-docs/images/ss-entities.png)

---

# Dockerizing Modules

In project root directory:

    mvn docker:build

#### When you run this command

    docker image ls

#### It should look like this

| REPOSITORY                      | TAG          | SIZE    |
|---------------------------------|--------------|---------|
| ms-app-mis-account-service      | 1.0.0        | 256MB   |
| ms-app-mis-account-service      | latest       | 256MB   |
| ms-app-mis-product-service      | 1.0.0        | 256MB   |
| ms-app-mis-product-service      | latest       | 256MB   |
| ms-app-mis-notification-service | 1.0.0        | 258MB   |
| ms-app-mis-notification-service | latest       | 258MB   |
| ms-app-mis-campaign-service     | 1.0.0        | 258MB   |
| ms-app-mis-campaign-service     | latest       | 258MB   |
| ms-app-mas-hystrix-service      | 1.0.0        | 219MB   |
| ms-app-mas-hystrix-service      | latest       | 219MB   |
| ms-app-mas-eureka-service       | 1.0.0        | 219MB   |
| ms-app-mas-eureka-service       | latest       | 219MB   |
| ms-app-mas-admin-service        | 1.0.0        | 224MB   |
| ms-app-mas-admin-service        | latest       | 224MB   |
| ms-app-mas-config-service       | 1.0.0        | 220MB   |
| ms-app-mas-config-service       | latest       | 220MB   |

---

#### Delete All Created Images

    docker rmi $(docker images | grep 'ms-app-')

---

# Done

* MS Structure (MAS)
* Feign Communication
* Query Communication
* Business (MIS)
* Dockerizing Modules

# TO-DO

* <b> Gateway improvement with spring cloud gateway </b>
* <b> Load Balance improvement with spring cloud load balancer</b>
* Config server encryption-decryption
* Hot config update (refreshcope etc..)
* Admin server duplicate instance?
* Auth server

---

* Mail notification implementation
* Phone notification implementation
* Phone notification simulation

# DB URL

* User : jdbc:h2:mem:account-db
* Product : jdbc:h2:mem:product-db
* Notification : jdbc:h2:mem:notification-db
* Campaign : jdbc:h2:mem:campaign-db

# Test Data

(These are not necessary for now)

<b>ACCOUNT</b>

| ID    | EMAIL              | NAME            | PHONE             | SURNAME            |
|-------|--------------------|-----------------|-------------------|--------------------|
| 1     | account1@mail.com  | account-1-name  | +905552223344     | account-1-surname  |
| 2     | account2@mail.com  | account-2-name  | +905552223344     | account-2-surname  |
| 3     | account4@mail.com  | account-3-name  | +905552223344     | account-3-surname  |
| 4     | account4@mail.com  | account-4-name  | +905552223344     | account-4-surname  |
| 5     | account5@mail.com  | account-5-name  | +905552223344     | account-5-surname  |

<b>Product</b>

| ID  | DESCRIPTION            | NAME       |
|-----|------------------------|------------|
| 1   | Product-1-Description  | Product-1  |
| 2   | Product-2-Description  | Product-2  |
| 3   | Product-3-Description  | Product-3  |
| 4   | Product-4-Description  | Product-4  |
| 5   | Product-5-Description  | Product-5  |

---

# Microservice Utility Modules SS

<b>Eureka</b>

![Eureka](dev-docs/images/ss-eureka.png)

<b>Admin Server</b>

![AdminServer](dev-docs/images/ss-admin-server-1.png)
![AdminServer](dev-docs/images/ss-admin-server-2.png)
![AdminServer](dev-docs/images/ss-admin-server-3.png)

<b>Zipkin</b>

![Zipkin](dev-docs/images/ss-zipkin-1.png)
![Zipkin](dev-docs/images/ss-zipkin-2.png)
![Zipkin](dev-docs/images/ss-zipkin-3.png)
images/
<b>RabbitMqManager</b>

![RabbitMqManager](dev-docs/images/ss-rabbitmq-1.png)



---

### Tags
* spring cloud microservice example
* microservice example
* api gateway example
* spring cloud gateway example
* load balance example
* spring cloud load balancer example
* config server example
* eureka server example
* admin server example
* zipkin example