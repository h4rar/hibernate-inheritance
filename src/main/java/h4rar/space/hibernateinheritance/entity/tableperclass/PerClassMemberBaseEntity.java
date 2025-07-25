package h4rar.space.hibernateinheritance.entity.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Базовый клас клиентов.
 */
@Setter
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "table_per_class_member_base_entity")
@Entity
public class PerClassMemberBaseEntity {
    @Id
    private UUID id = UUID.randomUUID();
    private String inn;
}
