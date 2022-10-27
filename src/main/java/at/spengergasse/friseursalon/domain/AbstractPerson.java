package at.spengergasse.friseursalon.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@AllArgsConstructor

@MappedSuperclass
public abstract class AbstractPerson extends AbstractPersistable<Long> {

    @Column(length = 32)
    private String userName;
    @Column(length = 32)
    private String password;
    @Column(length = 32)
    private String firstName;
    @Column(length = 64)
    private String lastName;

}
