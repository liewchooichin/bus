package myapp.bus.ltaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myapp.bus.busEntity.BusRoute;

@Repository
public interface BusRouteRepository extends JpaRepository<BusRoute, Long>{
  
} 