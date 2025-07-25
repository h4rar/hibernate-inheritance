package h4rar.space.hibernateinheritance.repository.tableperclass;

import h4rar.space.hibernateinheritance.entity.tableperclass.PerClassMemberBaseEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Репозиторий для работы с ошибками миграции.
 * @author Anton Kharchenko
 */
@ConditionalOnProperty(value = "inheritance-type", havingValue = "tableperclass")
public interface MemberBaseEntityRepository extends CrudRepository<PerClassMemberBaseEntity, UUID> {
}
