# atividade-springboot-actuator

## About this project
  - The purpose of this project is to connect two services created with springboot and retrieve informations stored on mongodb.
## Dependencies
  - **mongodb**
## Deploy

  - **Database**
    - Start a terminal 
      - run "mongod"
    - Start a terminal
      - Access the folder "server"
      - Run ./gradlew bootRun
  - **Client**
    - Start a terminal
      - Access the folder "client"
      - Run ./gradlew bootRun

### Swagger
  - Run Client (See on Deploy section)
  - Access "http://localhost:8080/swagger-ui.html" on browser

### Examples
  - "localhost:8080/states"
    - Returns all states covid informations.
  - "localhost:8080/states/pe"
    - Returns pernambuco covid informations.

### Twelve Factors
  - **This application follows the following standards of the twelve factors**
    - Codebase
    - Dependencies
    - Portbinding
    - Backing Services