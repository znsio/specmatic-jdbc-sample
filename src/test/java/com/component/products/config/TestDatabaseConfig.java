package com.component.products.config;

import in.specmatic.database.mock.ExternalStub;
import in.specmatic.database.mock.JdbcMockFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

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
        if (jdbcMockFactoryCatalogue == null)
            jdbcMockFactoryCatalogue = new JdbcMockFactory(new ExternalStub("localhost", 9000));
        if (mockDataSourceCatalogue == null) mockDataSourceCatalogue = jdbcMockFactoryCatalogue.createDataSource();
        return jdbcMockFactoryCatalogue;
    }



}
