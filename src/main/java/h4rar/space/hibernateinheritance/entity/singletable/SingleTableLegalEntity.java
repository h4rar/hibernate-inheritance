package h4rar.space.hibernateinheritance.entity.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
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
@DiscriminatorValue("LE")
public class SingleTableLegalEntity extends SingleTableLegalMemberBaseEntity {
    /**
     * Основной Государственный Регистрационный Номер.
     */
    private String ogrn;
}
