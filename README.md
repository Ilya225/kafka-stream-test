### Stream app

#### Run
First run docker-compose file 
```bash
docker-compose up -d
```


Build project
```bash
./gradlew build
```  

Then Run stream application
```bash
./graldew run
```

Then Run REST service
```bash
./gradlew rest:bootRun
```

#### Endpoints

all devices:
``GET http://localhost:8080/devices``

all device events
```GET http://localhost:8080/events/:device_id```