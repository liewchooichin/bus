package myapp.bus.appEntity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppBusArrivalController {
  // autowired service
  private AppBusArrivalService busArrivalService;

  // constructor
  public AppBusArrivalController(AppBusArrivalService busArrivalService) {
    this.busArrivalService = busArrivalService;
  }

  @GetMapping("/app/bus-arrival")
  public ResponseEntity<?> getBusArrivalTime(
      @RequestParam String BusStopCode,
      @RequestParam(required=false, defaultValue="") String ServiceNo) {
    // call the service to get the arrival time
    String result = busArrivalService.getBusArrivalTime(BusStopCode, ServiceNo);
    // return the response
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
