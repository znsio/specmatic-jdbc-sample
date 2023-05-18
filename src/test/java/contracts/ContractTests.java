package contracts;

import com.tbp.crud.SpringBootCrudJpaH2Application;
import com.tbp.crud.config.TestDatabaseConfig;
import in.specmatic.stub.ContractStub;
import in.specmatic.test.SpecmaticJUnitSupport;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

import static in.specmatic.stub.API.createStub;

@SpringBootTest(classes = SpringBootCrudJpaH2Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = {TestDatabaseConfig.class})
public class ContractTests extends SpecmaticJUnitSupport {

    private static ConfigurableApplicationContext context;

    private static ContractStub stub;

    @BeforeAll
    public static void setUp() {
        System.setProperty("host", "localhost");
        System.setProperty("port", "9090");
        System.setProperty("endpointsAPI", "http://localhost:9090/actuator/mappings");
        System.setProperty("spring.profiles.active", "contract-tests");
        stub =  createStub("localhost", 9000);
    }

    @AfterAll
    public static void tearDown() throws IOException {
        if (stub != null) {
            stub.close();
        }
    }
}