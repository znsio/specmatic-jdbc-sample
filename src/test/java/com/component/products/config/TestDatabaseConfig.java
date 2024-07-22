package com.component.products.config;

import io.specmatic.jdbc.stub.JdbcStubFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.io.File;

@TestConfiguration
@Primary
@Profile("contract-tests")
public class TestDatabaseConfig {

    public static final int DATABASE_STUB_PORT = 9010;
    public static final String DATABASE_EXPECTATIONS_DIRECTORY = new File("src/test/resources/specmatic/jdbc/stub/expectations").getAbsolutePath();

    @Primary
    @Bean
    public DataSource dataSource() {
        return new JdbcStubFactory(DATABASE_STUB_PORT, DATABASE_EXPECTATIONS_DIRECTORY).createDataSource();
    }

}
