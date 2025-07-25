package h4rar.space.hibernateinheritance.entity.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Физическое лицо (ФЛ).
 */
@Setter
@Entity
@ToString(callSuper = true)
@Table(name = "mapped_super_class_physical_person")
public class MappedSuperClassPhysicalPerson extends MappedSuperClassLegalMemberBaseEntity {
    /**
     * Гражданство.
     */
    private String nationalityCountryCode;
}
