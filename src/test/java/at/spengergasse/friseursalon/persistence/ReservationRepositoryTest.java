package at.spengergasse.friseursalon.persistence;

import at.spengergasse.friseursalon.domain.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

@DataJpaTest
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @BeforeEach
    void setup() {
        assumeThat(reservationRepository).isNotNull();
    }

    @Test
    void ensureSaveAndRereadOfPhotoWorksCorrectly() {

        //given
        Reservation reservation1 = Reservation.builder()
                .reservationName("SelciSBT")
                .creationTS(LocalDateTime.now())
        //        .customer(sbt)
        //        .product()
        //        .service()
        //        .bookedProduct()
        //        .bookedService()
                .build();

        //when
        var saved1 = reservationRepository.saveAndFlush(reservation1);  //Photo yazma, kendi geliyor.
//        var saved2 = reservationRepository.saveAndFlush(reservation2);  //Photo yazma, kendi geliyor.

        //then
        assertThat(saved1).isSameAs(reservation1);
        assertThat(saved1.getId()).isNotNull();

//        assertThat(saved2).isSameAs(reservation2);
//        assertThat(saved2.getId()).isNotNull();

    }
}
