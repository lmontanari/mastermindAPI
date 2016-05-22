
# Mastermind API

## Technologies used
Spring boot 1.3.5.RELEASE

Maven 3.3.3

MongoDB 3.2

Swagger 2.0
  
## Installing and testing
1. We stored our data in the cloud. There is no need to install a local database;
2. Type `mvn spring-boot:run` from the root project directory to start the application;
3. Check the Swagger API: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
4. When creating a new game, decide whether you want to play single or multi player;
5. Copy the generated game key and then make your guess using the guess endpoint;
6. You can check the game status (or any other game) using showGameStatus endpoint;
7. You can check all possible colors using getAllColors endpoint.

## URLs
To see all the endpoints created, please check it trough Swagger documentation:

Swagger: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Contact
Bruno Lellis (brunolellis@gmail.com)

Lucas Montanari (lucas_montanari@hotmail.com)
