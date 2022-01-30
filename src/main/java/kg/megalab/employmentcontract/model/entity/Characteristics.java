package kg.megalab.employmentcontract.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_characteristics")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Characteristics extends AbstractPersistable<Long> {

    @ElementCollection // For lists of simple objects
    @ColumnDefault("'N/A'")
    @Column(name = "hard_skills", nullable = false)
    List<String> hardSkills;

    @ElementCollection
    @ColumnDefault("'N/A'")
    @Column(name = "soft_skills", nullable = false)
    List<String> softSkills;

    @ElementCollection
    @ColumnDefault("'N/A'")
    @Column(name = "languages", nullable = false)
    List<String> languages;

//    @OneToOne(mappedBy = "characteristics")
//    Employee employee;

}
