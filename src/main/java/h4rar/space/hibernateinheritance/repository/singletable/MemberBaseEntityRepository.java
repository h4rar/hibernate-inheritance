package h4rar.space.hibernateinheritance.repository.singletable;

import h4rar.space.hibernateinheritance.entity.singletable.SingleTableLegalMemberBaseEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Репозиторий для работы с ошибками миграции.
 * @author Anton Kharchenko
 */
@ConditionalOnProperty(value = "inheritance-type", havingValue = "singletable")
public interface MemberBaseEntityRepository extends CrudRepository<SingleTableLegalMemberBaseEntity, UUID> {
}
