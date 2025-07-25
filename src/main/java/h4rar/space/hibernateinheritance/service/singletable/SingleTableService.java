package h4rar.space.hibernateinheritance.service.singletable;

import h4rar.space.hibernateinheritance.entity.singletable.SingleTableLegalEntity;
import h4rar.space.hibernateinheritance.entity.singletable.SingleTableLegalMemberBaseEntity;
import h4rar.space.hibernateinheritance.entity.singletable.SingleTablePhysicalPerson;
import h4rar.space.hibernateinheritance.repository.singletable.MemberBaseEntityRepository;
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
@ConditionalOnProperty(value = "inheritance-type", havingValue = "singletable")
public class SingleTableService implements InheritanceService {

    private final DataSource dataSource;
    private final MemberBaseEntityRepository memberBaseEntityRepository;

    @SneakyThrows
    @PostConstruct
    void setUp() {
        try (Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("db/singletable/init.sql"));
        }
    }

    @Override
    @Transactional
    public void run() {
        SingleTablePhysicalPerson perClassCreditCard = new SingleTablePhysicalPerson();
        perClassCreditCard.setInn("00001");
        perClassCreditCard.setNationalityCountryCode("RUS");
        memberBaseEntityRepository.save(perClassCreditCard);

        final SingleTableLegalEntity perClassBankAccount = new SingleTableLegalEntity();
        perClassBankAccount.setInn("00002");
        perClassBankAccount.setOgrn("ogrn_00014");
        memberBaseEntityRepository.save(perClassBankAccount);

        final List<SingleTableLegalMemberBaseEntity> list = StreamSupport.stream(memberBaseEntityRepository.findAll().spliterator(), false)
                .toList();
        System.out.println(list);
    }
}
