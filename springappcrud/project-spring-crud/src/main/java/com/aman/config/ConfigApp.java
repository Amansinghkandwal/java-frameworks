package com.aman.config;


import com.aman.db.DatabaseConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.aman")
public class ConfigApp {

    @Bean(initMethod = "init",destroyMethod = "cleanUp")
    public DatabaseConnection databaseConnection()
    {
        return new DatabaseConnection();
    }

}
