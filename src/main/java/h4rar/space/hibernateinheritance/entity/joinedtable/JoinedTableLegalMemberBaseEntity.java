package h4rar.space.hibernateinheritance.entity.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Базовый клас клиентов.
 */
@Setter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "joined_table_legal_member_base")
public abstract class JoinedTableLegalMemberBaseEntity {
    @Id
    private UUID id = UUID.randomUUID();
    private String inn;
}
