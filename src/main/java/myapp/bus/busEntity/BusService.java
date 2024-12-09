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
@Table(name="bus_service")
public class BusService {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="BusServiceId")
  private Long busServiceId;

  @Column(name="ServiceNo")
  private String serviceNo;

  @Column(name="Operator")
  private String operator;

  @Column(name="Direction")
  private Integer direction;

  @Column(name="Category")
  private String category;

  @Column(name="OriginCode")
  private String originCode;

  @Column(name="DestinationCode")
  private String destinationCode;

  @Column(name="AM_Peak_Freq")
  private String aM_Peak_Freq;

  @Column(name="AM_Offpeak_Freq")
  private String aM_Offpeak_Freq;

  @Column(name="PM_Peak_Freq")
  private String pM_Peak_Freq;

  @Column(name="PM_Offpeak_Freq")
  private String pM_Offpeak_Freq;

  @Column(name="LoopDesc")
  private String loopDesc;
}
