package myapp.bus.ltaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myapp.bus.busEntity.BusStop;
import java.util.List;


@Repository
public interface BusStopRepository extends JpaRepository<BusStop, Long>{
  List<BusStop> findByBusStopCodeIgnoreCase(String busStopCode);
} 