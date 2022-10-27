package at.spengergasse.friseursalon.domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;


@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor  //asagida Construction tanimladigim icin buna gerek yok.
@Builder

@Entity
@Table(name="reservations")  //Database Table creation

public class Reservation extends AbstractPersistable<Long> {

    @Column(length = 64)
    private String reservationName;
    private LocalDateTime creationTS;

//    @ManyToOne  //many reservations by one customer
//    @JoinColumn(name = "customer_id")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(foreignKey = @ForeignKey(name = "reservation_customer_id"))
    private Customer customer;

//    @ManyToOne  //many reservations for one product
//    @JoinColumn(name = "product_id")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(foreignKey = @ForeignKey(name = "reservation_product_id"))
    private Product product;

//    @ManyToOne  //many reservations for one service
//    @JoinColumn(name = "service_id")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(foreignKey = @ForeignKey(name = "reservation_service_id"))
    private Service service;

    private BookedProduct bookedProduct;
    private BookedService bookedService;

    public Reservation(String reservationName, LocalDateTime creationTS, Customer customer, Product product,
                       Service service, BookedProduct bookedProduct, BookedService bookedService) {
        this.reservationName = reservationName;
        this.creationTS = creationTS;
        this.customer = customer;
        this.product = product;
        this.service = service;
        this.bookedProduct = bookedProduct;
        this.bookedService = bookedService;
    }

}
