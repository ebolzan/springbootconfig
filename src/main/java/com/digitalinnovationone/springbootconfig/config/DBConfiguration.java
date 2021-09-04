package com.digitalinnovationone.springbootconfig.config;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {

    private String driveClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String testDatabaseConnection()
    {
        System.out.println("database h2");
        System.out.println(url);
        System.out.println(driveClassName);

        return "DB connection to h2";
    }

    @Profile("prod")
    @Bean
    public String productionDatabaseConnection()
    {
        System.out.println("database sql");
        System.out.println(url);
        System.out.println(driveClassName);

        return "DB connection to mysql";
    }
}
