package h4rar.space.hibernateinheritance.entity.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.ToString;

/**
 * Физическое лицо (ФЛ).
 */
@Setter
@Entity
@ToString(callSuper = true)
@Table(name = "joined_table_physical_persons")
public class JoinedTablePhysicalPerson extends JoinedTableLegalMemberBaseEntity {
    /**
     * Гражданство.
     */
    private String nationalityCountryCode;
}
