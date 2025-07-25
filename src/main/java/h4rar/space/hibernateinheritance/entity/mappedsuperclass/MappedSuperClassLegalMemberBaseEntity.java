package h4rar.space.hibernateinheritance.entity.mappedsuperclass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
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
@MappedSuperclass
public abstract class MappedSuperClassLegalMemberBaseEntity {
    @Id
    private UUID id = UUID.randomUUID();
    private String inn;
}
