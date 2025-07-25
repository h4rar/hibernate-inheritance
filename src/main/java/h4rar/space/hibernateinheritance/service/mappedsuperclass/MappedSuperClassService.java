package h4rar.space.hibernateinheritance.service.mappedsuperclass;

import h4rar.space.hibernateinheritance.entity.mappedsuperclass.MappedSuperClassLegalEntity;
import h4rar.space.hibernateinheritance.entity.mappedsuperclass.MappedSuperClassLegalMemberBaseEntity;
import h4rar.space.hibernateinheritance.entity.mappedsuperclass.MappedSuperClassPhysicalPerson;
import h4rar.space.hibernateinheritance.repository.mappedsuperclass.LegalEntityRepository;
import h4rar.space.hibernateinheritance.repository.mappedsuperclass.LegalMemberBaseEntityRepository;
import h4rar.space.hibernateinheritance.repository.mappedsuperclass.PhysicalPersonRepository;
import h4rar.space.hibernateinheritance.service.InheritanceService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

/**
 * @author Anton Kharchenko
 */
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(value = "inheritance-type", havingValue = "mappedsuperclass")
public class MappedSuperClassService implements InheritanceService {

    private final DataSource dataSource;
    private final LegalMemberBaseEntityRepository legalMemberBaseEntityRepository;
    private final PhysicalPersonRepository physicalPersonRepository;
    private final LegalEntityRepository legalEntityRepository;

    @SneakyThrows
    @PostConstruct
    void setUp() {
        try (Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("db/mappedsuperclass/init.sql"));
        }
    }

    @Override
    @Transactional
    public void run() {
        MappedSuperClassPhysicalPerson mappedSuperClassPhysicalPerson = new MappedSuperClassPhysicalPerson();
        mappedSuperClassPhysicalPerson.setInn("00001");
        mappedSuperClassPhysicalPerson.setNationalityCountryCode("RUS");
        legalMemberBaseEntityRepository.save(mappedSuperClassPhysicalPerson);

        final MappedSuperClassLegalEntity mappedSuperClassLegalEntity = new MappedSuperClassLegalEntity();
        mappedSuperClassLegalEntity.setInn("00002");
        mappedSuperClassLegalEntity.setOgrn("ogrn_00014");
        legalMemberBaseEntityRepository.save(mappedSuperClassLegalEntity);

        List<MappedSuperClassPhysicalPerson> mappedSuperClassPhysicalPersonAll =
                StreamSupport.stream(physicalPersonRepository.findAll().spliterator(), false)
                        .toList();
        List<MappedSuperClassLegalEntity> mappedSuperClassLegalEntityAll =
                StreamSupport.stream(legalEntityRepository.findAll().spliterator(), false)
                        .toList();
        final ArrayList<MappedSuperClassLegalMemberBaseEntity> all = new ArrayList<>(mappedSuperClassPhysicalPersonAll);
        all.addAll(mappedSuperClassLegalEntityAll);
        System.out.println("all: " + all);
    }
}
