package kg.megalab.employmentcontract.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Builder
@DynamicInsert // ???
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_address")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address extends AbstractPersistable<Long> {

    @ColumnDefault("'N/A'")
    @Column(name = "country", nullable = false)
    String country;

    @ColumnDefault("'N/A'")
    @Column(name = "city", nullable = false)
    String city;

    @ColumnDefault("'N/A'")
    @Column(name = "street", nullable = false)
    String street;

    @ColumnDefault("'N/A'")
    @Column(name = "house", nullable = false)
    String house;

    @Column(name = "apartment")
    Integer apartment;

    @Column(name = "postcode")
    Long postcode;

//    @OneToOne(mappedBy = "address")
//    Employee employee;

}
