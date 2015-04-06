# Spring Rest MongoDB

## Prerequisites

1. Java 7+ (I used Java 1.8.0_25)
2. MongoDB [https://www.mongodb.org/downloads](https://www.mongodb.org/downloads)
3. Tomcat 7,8

## Steps to run

1. Using embedded Tomcat

..* Build the war file using this command from the project root `mvn clean package`
..* Run the war file using this command from the project root `java -jar target/springRestMongo.war`

2. Using standalone Tomcat

..* Build the war file using this command from the project root `mvn clean package`
..* Copy the war file into your tomcats webapps folder and start tomcat.