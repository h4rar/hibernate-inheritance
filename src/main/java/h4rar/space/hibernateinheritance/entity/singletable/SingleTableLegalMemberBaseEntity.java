package h4rar.space.hibernateinheritance.entity.singletable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
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
import org.hibernate.annotations.DiscriminatorFormula;

import java.util.UUID;

/**
 * Базовый клас клиентов.
 */
@Setter
@ToString
@Entity
@Table(name = "single_table_member_base")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "D_TYPE")
//@DiscriminatorFormula("CASE WHEN ogrn IS NOT NULL THEN 'LE' ELSE 'PP' END")
public abstract class SingleTableLegalMemberBaseEntity {
    @Id
    private UUID id = UUID.randomUUID();
    private String inn;
}
