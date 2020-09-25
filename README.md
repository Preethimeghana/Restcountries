# RestCountries Application

This application helps you get the list of countries based on country name, region, calling code, currency, language, capital city.

Each country will have fields like name, topLevelDomain, alpha2Code, alpha3Code, callingCodes, capital, altSpellings, region, subregion, population, area, timezones, languages, translations, flag, cioc

## Getting Started

This application was developed using Spring Boot, H2DB In Memory Database and JPA.

## Requirements

Java - 1.8.x

Maven - 3.x.x

## Steps to Setup

**1. Configure H2DB Database

+ open `src/main/resources/application.properties`

+ change `spring.datasource.url` value for database as "jdbc:h2:mem:db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE"

+ Data File country.json is added to src/main/resources/data

**2. Build and run the app using maven**

```bash
mvn clean install
java -jar target/restcountries 0.0.1-SNAPSHOT.jar```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore GraphQL

The app defines following endpoints (GET Request)

Endpoint Name - HTTP Request Type

http://localhost:8080/rest/v2/all - All Countries

http://localhost:8080/rest/v2/name/{name} - Countries By Name

http://localhost:8080/rest/v2/name/{name}?fullText=true - Countries By Full Name

http://localhost:8080/rest/v2/alpha/{code} - Countries By Code

http://localhost:8080/rest/v2/alpha?codes={codes} - Countries By Mutiple Code

http://localhost:8080/rest/v2/currency/{currency} - Countries By Currency

http://localhost:8080/rest/v2/lang/{language} - Countries By Language

http://localhost:8080/rest/v2/capital/{capital} - Countries By Capital

http://localhost:8080/rest/v2/region/{region} - Countries by region

http://localhost:8080/rest/v2/callingcode/{callingcode} - Countries by callingcode

http://localhost:8080/rest/v2/country - Create a new country

You can test them using postman or any other rest client.

## Running the tests

To run the unit tests, call mvn test