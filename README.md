# klm-usecase

-> Implementation/Angular-UI directory contains code Front-end Code. Below are the technologies and components used
      
      1. Angular 5 framework
      
      2. Bootstrap CSS
      
      3. Angular Material Components for Autocomplete, Table/Grid
      
      4. PieChart from ng2-charts 
      
      5. Angular CLI for build
      
-> Implementation/spring-boot directory contains code Server code implemented with Spring-Boot. The contents of 'dist' directory of Angular cli build is placed inside spring project under 'src/main/resources/static'.

-> MockService directory contains mock api for location and fares.

# Setup

1. Clone the repository and start the mockservice (by executing the below command in 'MockService' directory).
     
     `./gradlew bootRun`
      
2. Execute the above command in 'Implementation/spring-boot' directory to start the application

Access the application at the link - `http://localhost:9000/travel/index.html`
      


