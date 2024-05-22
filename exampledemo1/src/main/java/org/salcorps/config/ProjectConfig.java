package org.salcorps.config;


import org.salcorps.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean(name="audiVehicle")
    Vehicle vehicle() {
        var veh = new Vehicle();
        veh.setName("Audi R8");
        return veh;
    }
    @Bean(value = "ferrariVehicle")
    Vehicle vehicle1() {
        var veh = new Vehicle();
        veh.setName("Ferrari");
        return veh;
    }
    @Bean("lamboVehicle")
    Vehicle vehicle2() {
        var veh = new Vehicle();
        veh.setName("Lambo");
        return veh;
    }

    @Primary
    @Bean("marutiVehicle")
    Vehicle vehicle4() {
        var veh = new Vehicle();
        veh.setName("Maruti");
        return veh;
    }

    @Bean
    String hello() {
        return "Hello World";
    }
    @Bean
    Integer number() {
        return 16;
    }
}
