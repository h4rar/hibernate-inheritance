package h4rar.space.hibernateinheritance.entity.mappedsuperclass;

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
@Table(name = "mapped_super_class_legal_entity")
public class MappedSuperClassLegalEntity extends MappedSuperClassLegalMemberBaseEntity {
    /**
     * Основной Государственный Регистрационный Номер.
     */
    private String ogrn;
}
