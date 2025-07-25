package h4rar.space.hibernateinheritance.service.joinedtable;

import h4rar.space.hibernateinheritance.entity.joinedtable.JoinedTableLegalEntity;
import h4rar.space.hibernateinheritance.entity.joinedtable.JoinedTableLegalMemberBaseEntity;
import h4rar.space.hibernateinheritance.entity.joinedtable.JoinedTablePhysicalPerson;
import h4rar.space.hibernateinheritance.repository.joinedtable.LegalMemberBaseEntityRepository;
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
import java.util.List;
import java.util.stream.StreamSupport;

/**
 * @author Anton Kharchenko
 */
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(value = "inheritance-type", havingValue = "joinedtable")
public class JoinedTableService implements InheritanceService {

    private final DataSource dataSource;
    private final LegalMemberBaseEntityRepository legalMemberBaseEntityRepository;

    @SneakyThrows
    @PostConstruct
    void setUp() {
        try (Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("db/joinedtable/init.sql"));
        }
    }

    @Override
    @Transactional
    public void run() {
        JoinedTablePhysicalPerson joinedTablePhysicalPerson = new JoinedTablePhysicalPerson();
        joinedTablePhysicalPerson.setInn("00001");
        joinedTablePhysicalPerson.setNationalityCountryCode("RUS");
        legalMemberBaseEntityRepository.save(joinedTablePhysicalPerson);

        final JoinedTableLegalEntity joinedTableLegalEntity = new JoinedTableLegalEntity();
        joinedTableLegalEntity.setInn("00002");
        joinedTableLegalEntity.setOgrn("ogrn_00014");
        legalMemberBaseEntityRepository.save(joinedTableLegalEntity);

        final List<JoinedTableLegalMemberBaseEntity> list = StreamSupport.stream(legalMemberBaseEntityRepository.findAll().spliterator(), false)
                .toList();
        System.out.println(list);
    }
}
