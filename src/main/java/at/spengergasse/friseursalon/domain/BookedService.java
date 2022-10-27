package at.spengergasse.friseursalon.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder

@Embeddable
public class BookedService {

    private Integer serviceAmount;
    private LocalDateTime serviceTS;  //should be booking date and time

//    @ManyToOne  //many Service von einem Barber
//    @JoinColumn(name = "service_barber_id")

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(foreignKey = @ForeignKey(name = "bookedService_barber_id"))

    private Barber serviceBarber;

}
