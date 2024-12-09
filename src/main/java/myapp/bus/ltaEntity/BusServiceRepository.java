package myapp.bus.ltaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myapp.bus.busEntity.BusService;
import myapp.bus.busEntity.BusStop;
import java.util.List;


@Repository
public interface BusServiceRepository extends JpaRepository<BusService, Long>{
  List<BusService> findByServiceNoIgnoreCase(String serviceNo);
} 
