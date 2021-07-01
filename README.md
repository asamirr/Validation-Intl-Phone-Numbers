# Validation-Task

This repo contains ***both apps***. A React web application and a Spring Boot web application.

There's a Docker-compose file to execute the entire the project.

Just `cd Validation-Task`, run `docker-compose up -d`, wait till the containers start 
and then go to http://localhost:4680/

## To run the project locally without Docker

- `cd backend`
- `mvn spring-boot:run`

### Then move to the "frontend" directory
- `cd frontend`
- `npm start`
then go to "http://localhost:3000/"
