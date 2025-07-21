===============================
Microservice step by step
===============================
Step-1
Student-service

Step-2
Fee-Service

Step3
School-service

step-4
Service-registry


Step-5
Eureke-server

==========Requred dependecy=======================
Java 17 version


2. Student-Service, Fee-Service
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>

2. School Service
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webflux</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>

2. Service Registry (Route Api Gateway)

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-gateway</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-loadbalancer</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>

4.Eureka Server (Register Service)
		
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>

=========Properties file configuration=============
1.Student-service
server.port=8082
spring.application.name=STUDENT-SERVICE
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
eureka.instance.hostname=localhost
server.servlet.context-path = /student
==============================================
2. fee service
server.port=8083
spring.application.name=FEE-SERVICE
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
eureka.instance.hostname=localhost
server.servlet.context-path = /fee
==============================================
3. school service
server.port=8081
spring.application.name=SCHOOL-SERVICE
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
eureka.instance.hostname=localhost
server.servlet.context-path = /school
==============================================
4. datbase configuration in abobe service
spring.datasource.url=jdbc:mysql://localhost:3306/school
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username = root
spring.datasource.password = root

spring.datasource.hikari.connectionTimeout=30000
spring.datasource.hikari.idleTimeout=600000
spring.datasource.hikari.maxLifetime=1800000
spring.datasource.hikari.connection-timeout = 20000
spring.datasource.hikari.minimum-idle= 10
spring.datasource.hikari.maximum-pool-size= 10
spring.datasource.hikari.idle-timeout=10000
spring.datasource.hikari.max-lifetime= 1000
spring.datasource.hikari.auto-commit =true

spring.jpa.generate-ddl = true
spring.jpa.hibernate.ddl-auto= update

spring.jpa.hibernate.dll-auto=create-drop
#spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
==========================================================
4. eureka server
server.port=8761
spring.application.name=eureka-server
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false

==============================================
6. service registry yml file
server:
  port: 8080

spring:
  application:
    name: API-GATEWAY-SERVICE
  cloud:
    gateway:
      routes:
        - id: STUDENT-SERVICE
          uri: http://STUDENT-SERVICE
          predicates:
            - Path=/student/**
        - id: SCHOOL-SERVICE
          uri: lb://SCHOOL-SERVICE
          predicates:
            - Path=/school/**
        - id: FEE-SERVICE
          uri: lb://FEE-SERVICE
          predicates:
            - Path=/fee/**

eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8761/eureka/
  instance:
    hostname: localhost

=========databse MySql=========================== 

Schema-School
Table1- Student
Table2- Fee


=====================API Call service===============
port 8080 default port server

fee-service 
1. http://localhost:8083/fee/api/save-fee-student
post{
    "studentId": "1",
    "month": "May",
    "paidAmt": "500",
    "paidDate": "2025-05-01"
}
2. http://localhost:8083/fee/api/get-fee-details/student/1

student-service
1. http://localhost:8082/student/api/save-student
post{
    "name": "VAmshi",
    "age": 33,
    "email": "vamshi@gmail.com",
    "address": "hydrabad"
}

2.http://localhost:8082/student/api/get-student-by-id/7


School-service (default)
1.http://localhost:8081/school/welcome 

Calling two service internally student service and fee service
2.http://localhost:8080/school/get-student-details/student/1 








