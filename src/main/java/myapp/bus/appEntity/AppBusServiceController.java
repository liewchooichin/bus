package myapp.bus.appEntity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import myapp.bus.busEntity.BusService;
import myapp.bus.ltaEntity.BusServiceApiService;

@RestController
public class AppBusServiceController {
  // autowire
  private BusServiceApiService busServiceApiService;
  // constructor
  public AppBusServiceController(BusServiceApiService busServiceApiService){
    this.busServiceApiService = busServiceApiService;
  }
  // find by bus service no
  @GetMapping("/app/service-no/{serviceNo}")
  public ResponseEntity<?> findByServiceNo(@PathVariable String serviceNo){
    Map<String, Object> response = new LinkedHashMap<>();
    List<BusService> busServiceList = busServiceApiService.findByBusServiceNo(serviceNo);
    response.put("status", "Successful");
    response.put("data", busServiceList);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
