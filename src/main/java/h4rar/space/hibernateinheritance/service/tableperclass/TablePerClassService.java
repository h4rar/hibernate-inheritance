package h4rar.space.hibernateinheritance.service.tableperclass;

import h4rar.space.hibernateinheritance.entity.tableperclass.PerClassLegalEntity;
import h4rar.space.hibernateinheritance.entity.tableperclass.PerClassMemberBaseEntity;
import h4rar.space.hibernateinheritance.entity.tableperclass.PerClassPhysicalPerson;
import h4rar.space.hibernateinheritance.repository.tableperclass.MemberBaseEntityRepository;
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
@ConditionalOnProperty(value = "inheritance-type", havingValue = "tableperclass")
public class TablePerClassService implements InheritanceService {

    private final DataSource dataSource;
    private final MemberBaseEntityRepository memberBaseEntityRepository;

    @SneakyThrows
    @PostConstruct
    void setUp() {
        try (Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("db/tableperclass/init.sql"));
        }
    }

    @Override
    @Transactional
    public void run() {
        PerClassPhysicalPerson perClassPhysicalPerson = new PerClassPhysicalPerson();
        perClassPhysicalPerson.setInn("00001");
        perClassPhysicalPerson.setNationalityCountryCode("RUS");
        memberBaseEntityRepository.save(perClassPhysicalPerson);

        final PerClassLegalEntity perClassLegalEntity = new PerClassLegalEntity();
        perClassLegalEntity.setInn("00002");
        perClassLegalEntity.setOgrn("ogrn_00014");
        memberBaseEntityRepository.save(perClassLegalEntity);

        final List<PerClassMemberBaseEntity> list = StreamSupport.stream(memberBaseEntityRepository.findAll().spliterator(), false)
                .toList();
        System.out.println(list);
    }
}
