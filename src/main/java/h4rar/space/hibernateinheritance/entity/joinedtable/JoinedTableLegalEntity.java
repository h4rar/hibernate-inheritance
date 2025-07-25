package h4rar.space.hibernateinheritance.entity.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Юридическое лицо(ЮЛ).
 */
@Setter
@Entity
@ToString(callSuper = true)
@Table(name = "joined_table_legal_entity")
public class JoinedTableLegalEntity extends JoinedTableLegalMemberBaseEntity {
    /**
     * Основной Государственный Регистрационный Номер.
     */
    private String ogrn;
}
