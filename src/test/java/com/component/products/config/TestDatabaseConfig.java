package com.component.products.config;

import in.specmatic.database.mock.DatabaseStub;
import in.specmatic.database.mock.JdbcMockFactory;
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
    @DependsOn("primaryJdbcMockFactory")
    public DataSource dataSource() {
       return mockDataSourceCatalogue;
    }
    JdbcMockFactory jdbcMockFactoryCatalogue = null;
    DataSource mockDataSourceCatalogue = null;




    @Bean(destroyMethod = "close")
    public JdbcMockFactory primaryJdbcMockFactory() {
        if (jdbcMockFactoryCatalogue == null) {
            jdbcMockFactoryCatalogue = new JdbcMockFactory(new DatabaseStub("localhost", 9010), new File("./src/test/resources/db_stub_contract/db_data").getAbsolutePath());
        }
        if (mockDataSourceCatalogue == null) mockDataSourceCatalogue = jdbcMockFactoryCatalogue.createDataSource();
        return jdbcMockFactoryCatalogue;
    }



}
