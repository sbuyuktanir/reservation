package at.spengergasse.friseursalon.domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder

@Entity
@Table(name="countries")
public class Country extends AbstractPersistable<Long> {

    @Column(length = 64)
    private String name;

    @Column(length = 2)
    private String iso2Code;

}
