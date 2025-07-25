package h4rar.space.hibernateinheritance.repository.joinedtable;

import h4rar.space.hibernateinheritance.entity.joinedtable.JoinedTableLegalMemberBaseEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Репозиторий для работы с ошибками миграции.
 * @author Anton Kharchenko
 */
@ConditionalOnProperty(value = "inheritance-type", havingValue = "joinedtable")
public interface LegalMemberBaseEntityRepository extends CrudRepository<JoinedTableLegalMemberBaseEntity, UUID> {
}
