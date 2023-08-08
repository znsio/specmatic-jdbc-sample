package com.component.products.config;

import in.specmatic.jdbc.stub.JdbcStubFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.io.File;

@TestConfiguration
@Primary
@Profile("contract-tests")
public class TestDatabaseConfig extends DatabaseConfig {

    public static final int DATABASE_STUB_PORT = 9010;
    public static final String DATABASE_EXPECTATIONS_DIRECTORY = new File("./src/test/resources/db_stub_data").getAbsolutePath();

    @Primary
    @Bean
    public DataSource dataSource() {
        return new JdbcStubFactory(DATABASE_STUB_PORT, DATABASE_EXPECTATIONS_DIRECTORY).createDataSource();
    }

}
