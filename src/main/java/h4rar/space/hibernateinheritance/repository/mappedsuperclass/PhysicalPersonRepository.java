package h4rar.space.hibernateinheritance.repository.mappedsuperclass;

import h4rar.space.hibernateinheritance.entity.mappedsuperclass.MappedSuperClassPhysicalPerson;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Репозиторий для работы с ошибками миграции.
 * @author Anton Kharchenko
 */
@ConditionalOnProperty(value = "inheritance-type", havingValue = "mappedsuperclass")
public interface PhysicalPersonRepository extends CrudRepository<MappedSuperClassPhysicalPerson, UUID> {
}
