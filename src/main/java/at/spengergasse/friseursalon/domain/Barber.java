package at.spengergasse.friseursalon.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

@Entity
@Table(name="barbers")  //Database Table creation

public class Barber extends AbstractPerson{

    private String nickName;

    public Barber(String userName, String password, String firstName, String lastName, String nickName) {
        super(userName, password, firstName, lastName);
        this.nickName = nickName;
    }

}
