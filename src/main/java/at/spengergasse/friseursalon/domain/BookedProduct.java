package at.spengergasse.friseursalon.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder

@Embeddable
public class BookedProduct {

    private Integer productAmount;
    private LocalDateTime productTS;  //should be booking date and time

}
