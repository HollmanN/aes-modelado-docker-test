##Docker Test

Calculator application to test docker, based on REST services

- Ports:
    - 8080 -> Web port

- Build:

    You can choose to use the included maven distribution or use a local maven installation
    
    - Using embedded maven:
    
    1) Verify that docker ir running: 
    
        ```docker ps``` or ```docker version```
    
    2) On the root of the project execute
    
        ```./mvnw clean package install dockerfile:build```
    
        This will create the image.
    
    3) Verify the image with 
    
        ```docker images```
        
        You should see ```aes-model/docker-web-test:latest``` in the list
        
    4) Mount container with
        
        ```docker run -d -p 8080:8080 -t aes-model/docker-web-test:latest```
        
        The parameter -p sets a local port to the container. Be sure to pick one available local port.
        
    5) Go to ```localhost:8080/operations/health``` to check if the application is running

- Paths:

    - Server path: BASE_URL/operations
    - Health path: BASE_URL/operations/health
    - Swagger UI: BASE_URL/operations/swagger-ui.html

- All the endpoints receive a list as arguments

Example: BASE_URL/operations/sum/1,2,3,4,5 will calculate 1+2+3+4+5.

For more information, check the swagger-ui documentation.
    
