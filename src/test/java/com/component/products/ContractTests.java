package com.component.products;

import in.specmatic.test.SpecmaticJUnitSupport;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = ProductsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ContractTests extends SpecmaticJUnitSupport {

    @BeforeAll
    public static void setUp() {
        System.setProperty("host", "localhost");
        System.setProperty("port", "8080");
        System.setProperty("endpointsAPI", "http://localhost:8080/actuator/mappings");
        System.setProperty("spring.profiles.active", "contract-tests");
    }

}