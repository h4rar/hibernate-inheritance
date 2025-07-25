package h4rar.space.hibernateinheritance;

import h4rar.space.hibernateinheritance.service.InheritanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class HibernateInheritanceApplication {

    private final InheritanceService inheritanceService;

    public static void main(String[] args) {
        SpringApplication.run(HibernateInheritanceApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        inheritanceService.run();
    }
}
