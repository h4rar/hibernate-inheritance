package h4rar.space.hibernateinheritance.entity.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Физическое лицо (ФЛ).
 */
@Setter
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("PP")
public class SingleTablePhysicalPerson extends SingleTableLegalMemberBaseEntity {
    /**
     * Гражданство.
     */
    private String nationalityCountryCode;
}
