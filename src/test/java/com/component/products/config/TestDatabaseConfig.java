package com.component.products.config;

import in.specmatic.jdbc.stub.DatabaseStub;
import in.specmatic.jdbc.stub.JdbcStubFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.io.File;

@TestConfiguration
@Primary
@Profile("contract-tests")
public class TestDatabaseConfig extends DatabaseConfig {

    @Primary
    @Bean
    @DependsOn("primaryJdbcStubFactory")
    public DataSource dataSource(JdbcStubFactory jdbcStubFactory) {
        return jdbcStubFactory.createDataSource();
    }

    @Bean(destroyMethod = "close")
    public JdbcStubFactory primaryJdbcStubFactory() {
        return new JdbcStubFactory(new DatabaseStub("localhost", 9010), new File("./src/test/resources/db_stub_data").getAbsolutePath());
    }

}
