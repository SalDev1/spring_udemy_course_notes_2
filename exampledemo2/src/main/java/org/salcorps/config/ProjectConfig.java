package org.salcorps.config;


import org.salcorps.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
// Start scanning for spring annotations starting from
// defined based path.
@ComponentScan("org.salcorps.beans")
public class ProjectConfig {
    @Bean
    String hello() {
        return "Hello World";
    }
    @Bean
    Integer number() {
        return 16;
    }
}
