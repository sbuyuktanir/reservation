package at.spengergasse.friseursalon.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.Duration;
import java.util.Currency;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
// @Builder

@Entity
@Table(name="services")  //Database Table creation

public class Service extends AbstractPersistable<Long> {

    private String serviceName;
    private Currency servicePreis;
    private Duration serviceDuration;

    @Embedded  //die Attributes von BookedService.java zusätzlich gekriegt.
    @AttributeOverrides({
            @AttributeOverride(name ="serviceAmount", column = @Column(name = "bookedService_serviceAmount", length=16)),
            @AttributeOverride(name = "serviceTS", column = @Column(name = "bookedService_serviceTS")),
    //        @AttributeOverride(name = "serviceBarber", column = @Column(name = "bookedService_serviceBarber", length=32)),
    })
    private BookedService bookedService;

}
