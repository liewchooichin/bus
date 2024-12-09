package myapp.bus.busEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Must start field names with small letters

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bus_stop")
public class BusStop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="BusStopId")
  private Long busStopId;

  @Column(name="BusStopCode")
  private String busStopCode;

  @Column(name="RoadName")
  private String roadName;

  @Column(name="Description")
  private String description;

  @Column(name="Latitude")
  private Double latitude;

  @Column(name="Longitude")
  private Double longitude;
}
