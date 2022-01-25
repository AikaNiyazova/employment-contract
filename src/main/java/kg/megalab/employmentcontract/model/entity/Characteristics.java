package kg.megalab.employmentcontract.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_characteristics")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Characteristics extends AbstractPersistable<Long> {

    @Column(name = "hard_skills", nullable = false)
    String hardSkills;

    @Column(name = "soft_skills", nullable = false)
    String softSkills;

    @Column(name = "languages", nullable = false)
    String languages;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    Employee employee;

}
