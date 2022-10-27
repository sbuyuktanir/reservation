package at.spengergasse.friseursalon.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
// @Builder

@Entity
@Table(name="barbers")  //Database Table creation

public class Admin extends Barber{

    @Embedded  //die Attributes von PhoneNumber.java zusätzlich gekriegt.
    @AttributeOverrides({
            @AttributeOverride(name ="countryCode", column = @Column(name = "mobilePhoneNumber_country_code")),
            @AttributeOverride(name = "areaCode", column = @Column(name = "mobilePhoneNumber_area_code")),
            @AttributeOverride(name = "serialNumber", column = @Column(name = "mobilePhoneNumber_serial_number", length=16)),
    })
    private PhoneNumber mobilePhoneNumber;

    @Embedded  //die Attributes von PhoneNumber.java zusätzlich gekriegt.
    @AttributeOverrides({
            @AttributeOverride(name ="countryCode", column = @Column(name = "businessPhoneNumber_country_code")),
            @AttributeOverride(name = "areaCode", column = @Column(name = "businessPhoneNumber_area_code")),
            @AttributeOverride(name = "serialNumber", column = @Column(name = "businessPhoneNumber_serial_number", length=16)),
    })
    private PhoneNumber businessPhoneNumber;

    @Embedded  //die Attributes von Email.java zusätzlich gekriegt.
    @AttributeOverrides({
            @AttributeOverride(name ="address", column = @Column(name = "email_addess", length=128)),
    })
    private Email email;

    public Admin(String userName, String password, String firstName, String lastName, PhoneNumber mobilePhoneNumber,
                    PhoneNumber businessPhoneNumber, Email email, String nickName) {
        super(userName, password, firstName, lastName, nickName);
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.businessPhoneNumber = businessPhoneNumber;
        this.email = email;
    }

}
