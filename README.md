# Stackify Configuration

Application for tests with Stackify Retrace and EJB.

## Endpoins

```
# Soap WS
/Log/Service?wsdl
```

## Configuration

You should configure your apiKey on files:
- src/main/resources/log4j.properties
- src/main/resources/logback.xml
- src/main/resources/stackify-api.properties

## Using

### Java

Run in Glassfish

### Docker

```
mvn clean package
docker build -t stackify .
docker run --rm -it -p 8080:8080 -v /usr/local/stackify:/usr/local/stackify stackify
```

### Compose

```
mvn clean package
docker-compose up --build
```
