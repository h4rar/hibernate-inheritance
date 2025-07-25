package h4rar.space.hibernateinheritance.entity.tableperclass;

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
@Table(name = "table_per_class_physical_person")
public class PerClassPhysicalPerson extends PerClassMemberBaseEntity {
    /**
     * Гражданство.
     */
    private String nationalityCountryCode;
}
