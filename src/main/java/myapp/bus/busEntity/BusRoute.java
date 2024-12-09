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

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bus_route")
public class BusRoute {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="BusRouteId")
  private Long busRouteId;

  @Column(name="ServiceNo")
  private String serviceNo;

  @Column(name="Operator")
  private String operator;

  @Column(name="Direction")
  private String direction;

  @Column(name="StopSequence")
  private String stopSequence;

  @Column(name="BusStopCode")
  private String busStopCode;

  @Column(name="Distance")
  private String distance;

  @Column(name="WD_FirstBus")
  private String wD_FirstBus;

  @Column(name="WD_LastBus")
  private String wD_LastBus;

  @Column(name="SAT_FirstBus")
  private String sAT_FirstBus;

  @Column(name = "SAT_LastBus")
  private String sAT_LastBus;

  @Column(name = "SUN_FirstBus")
  private String sUN_FirstBus;

  @Column(name = "SUN_LastBus")
  private String sUN_LastBus;

}