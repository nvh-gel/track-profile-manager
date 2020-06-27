
## Track Profiler Manager
An API to manage tracks that are uploaded by user, that support uploading, viewing track profile

- An endpoint that allow users to upload "gpx" file and store mandatory information such as "metadata, waypoint, track" 
- An endpoint to return a list of "Latest tracks" from our users
- An endpoint to allow users to view details of their gpx file


## Project Structure

src  
- main
  - java
    - com.demo.profiler
      - controller (spring controller for api)
      - domain
        - customconverter (dozer custom convert for complex datatypes)
        - model (contains data model)
        - repository (crud repository for interact with database)
        - viewmodel (contain view models to interact with user)
      - service (contains services for business logic)
      - utils (utilization functions)
  - resources 
    - mappings (contains dozer bean mapper config file)
    - templates (contains mockup page for uploading)
    - application.properties (contains configurable variables)
    - beans.xml (contains beans definition)
    - data.sql (scripts for initialize h2 database)
- test


## Command

To boot up project
```shell script
mvn spring-boot:run
```

To test the APIs
- get latest tracks:
```shell script
curl http://localhost:8080/api/track
```

- get track details
```shell script
curl http://localhost:8080/api/track/<track-id>
```

- upload track file
```shell script
access upload page at http://localhost:8080
```
