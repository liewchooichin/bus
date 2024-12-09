# Notes

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
 
