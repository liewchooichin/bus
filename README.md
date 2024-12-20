# Notes

## API key

Put your API key here. Yet to find out how to safely secure the key.

```Java
public class ApiKey {
  // just to store the API Key for now
    // my api key
    public class ApiKey {
  // just to store the API Key for now
    // my api key
    @Value("${myApiKey}")
    public static String myApiKey;
}
```

### From Daniel's reply:

For API keys, you will learn how to handle it with secrets management in the next module.

A simple solution for now is to store your general application settings in `application.properties`, and the api key in `application-dev.properties` but git ignore the  `application-dev.properties`.   Then share this file directly with your teammates.  We are just trying to avoid exposing the API key in the Github repository.

Remember to set the active profile with `spring.profiles.active=dev` in `application.properties`.

### My additions:

The actual usage can be found here.

https://stackoverflow.com/questions/71588089/how-do-you-hide-api-key-when-using-spring-boot-with-maven

https://stackoverflow.com/questions/73339170/spring-boot-value-annotation-picks-up-key-from-application-properties-but-does

Store the key in **application-dev.properties**.
`myApiKey=<API KEY>`

In the file ApiKey.java, I use the key.

In **application.properties**, specify this:

`spring.profiles.active=dev`


## Rest Client

## Reference that works:

[New in Spring 6.1: RestClient](https://spring.io/blog/2023/07/13/new-in-spring-6-1-restclient)

## URI builder in RestClient

https://stackoverflow.com/questions/77592651/how-to-send-request-parameters-with-the-new-spring-boot-3-2-restclient

### Some result

   : Started BusApplication in 4.51 seconds (process running for 4.917)
Response status: 200 OK
Response headers: [Date:"Mon, 09 Dec 2024 03:45:21 GMT", Content-Type:"application/json;charset=UTF-8", Transfer-Encoding:"chunked", Connection:"keep-alive", Cache-Control:"no-store", Content-Language:"en-US", Strict-Transport-Security:"max-age=16070400; includeSubDomains", X-Frame-Options:"deny", X-XSS-Protection:"1; mode=block", X-Content-Type-Options:"nosniff", Content-Security-Policy:"default-src 'none'; script-src 'self'; connect-src 'self';img-src 'self'; style-src 'self'"]


## Object Mapping

From JSON to objects:

Sample file:

JSON file is like this:

```JSON
{

    "odata.metadata": "http://datamall2.mytransport.sg/ltaodataservice/$metadata#BusStops",

    "value": [

        {

            "BusStopCode": "01012",

            "RoadName": "Victoria St",

            "Description": "Hotel Grand Pacific",

            "Latitude": 1.29684825487647,

            "Longitude": 103.85253591654006

        },

        {

            "BusStopCode": "01013",

            "RoadName": "Victoria St",

            "Description": "St. Joseph's Ch",

            "Latitude": 1.29770970610083,

            "Longitude": 103.8532247463225

        },

        {

            "BusStopCode": "01019",

            "RoadName": "Victoria St",

            "Description": "Bras Basah Cplx",

            "Latitude": 1.29698951191332,

            "Longitude": 103.85302201172507

        },

        {

            "BusStopCode": "01029",

            "RoadName": "Nth Bridge Rd",

            "Description": "Opp Natl Lib",

            "Latitude": 1.2966729849642,

            "Longitude": 103.85441422464267

        }

    ]

}
```

POJO BusStop class is like this:

```Java
 

public class BusStop {

private Long busStopId;

private String busStopCode;

private String roadName;

private String description;

private Double latitute;

private Double longitute;

}
```

JSON to object mapping is like this:


```Java
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToBusStop {

    public static void main(String[] args) throws Exception {
        String jsonString = "{ \"odata.metadata\": \"http://datamall2.mytransport.sg/ltaodataservice/$metadata#BusStops\", \"value\": [ { \"BusStopCode\": \"01012\", \"RoadName\": \"Victoria St\", \"Description\": \"Hotel Grand Pacific\", \"Latitude\": 1.29684825487647, \"Longitude\": 103.85253591654006 }, { \"BusStopCode\": \"01013\", \"RoadName\": \"Victoria St\", \"Description\": \"St. Joseph's Ch\", \"Latitude\": 1.29770970610083, \"Longitude\": 103.8532247463225 }, { \"BusStopCode\": \"01019\", \"RoadName\": \"Victoria St\", \"Description\": \"Bras Basah Cplx\", \"Latitude\": 1.29698951191332, \"Longitude\": 103.85302201172507 }, { \"BusStopCode\": \"01029\", \"RoadName\": \"Nth Bridge Rd\", \"Description\": \"Opp Natl Lib\", \"Latitude\": 1.2966729849642, \"Longitude\": 103.85441422464267 } ] }";

        ObjectMapper objectMapper = new ObjectMapper();

        // Access the "value" array
        JsonNode rootNode = objectMapper.readTree(jsonString);
        JsonNode busStopsArray = rootNode.get("value");

        // Loop through each bus stop object in the array
        for (JsonNode busStopNode : busStopsArray) {
            BusStop busStop = new BusStop();
            busStop.setBusStopCode(busStopNode.get("BusStopCode").asText());
            busStop.setRoadName(busStopNode.get("RoadName").asText());
            busStop.setDescription(busStopNode.get("Description").asText());
            busStop.setLatitude(busStopNode.get("Latitude").asDouble());
            busStop.setLongitude(busStopNode.get("Longitude").asDouble());

            // Process the mapped busStop object (print details, store in database, etc.)
            System.out.println(busStop);
        }
    }
}
```

## SQLite3 

NOT WORKING.

Reference:

- https://github.com/Semo/spring-jpa-sqlite-sample/tree/master
- Baelduing example [Spring Boot With SQLite](https://www.baeldung.com/spring-boot-sqlite)
 
