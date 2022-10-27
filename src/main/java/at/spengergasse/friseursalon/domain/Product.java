package at.spengergasse.friseursalon.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Currency;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
// @Builder

@Entity
@Table(name="products")  //Database Table creation

public class Product extends AbstractPersistable<Long> {

    private String productName;
    private Currency productPreis;

    @Embedded  //die Attributes von BookedProduct.java zusätzlich gekriegt.
    @AttributeOverrides({
            @AttributeOverride(name ="productAmount", column = @Column(name = "bookedProduct_productAmount", length=16)),
            @AttributeOverride(name = "productTS", column = @Column(name = "bookedProduct_productTS")),
    })
    private BookedProduct bookedProduct;

}
