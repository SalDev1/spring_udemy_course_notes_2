package org.salcorps.config;


import org.salcorps.beans.Person;
import org.salcorps.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// Start scanning for spring annotations starting from
// defined based path.
@ComponentScan("org.salcorps.beans")
public class ProjectConfig {

}
