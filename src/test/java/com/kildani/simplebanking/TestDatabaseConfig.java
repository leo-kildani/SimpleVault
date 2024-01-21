package com.kildani.simplebanking;

import javax.sql.DataSource;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@TestConfiguration
public class TestDatabaseConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test_simplevault");
        dataSource.setUsername("simplevault_user");
        dataSource.setPassword("simplevault_password");
        return dataSource;
    }
}
