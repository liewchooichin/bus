package myapp.bus.appEntity;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myapp.bus.busEntity.BusStop;
import myapp.bus.ltaEntity.BusStopApiService;

@RestController
public class AppBusStopController {
  // autowire
  private BusStopApiService busStopApiService;

  // constructor
  public AppBusStopController(BusStopApiService busStopApiService){
    this.busStopApiService = busStopApiService;
  }

  // get the bus stop code
  @GetMapping("/app/bus-stop/{busStopCode}")
  public ResponseEntity<?> findByBusStopCode(@PathVariable String busStopCode){
    Map<String, Object> response = new LinkedHashMap<>();
    List<BusStop> busStopList = busStopApiService.findByBusStopCode(busStopCode);
    // prepare the response
    response.put("status", "Successful");
    response.put("data", busStopList);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
