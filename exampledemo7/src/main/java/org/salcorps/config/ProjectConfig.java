package org.salcorps.config;

import org.salcorps.beans.Speakers;
import org.salcorps.beans.Vehicle;
import org.salcorps.beans.Wheels;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("org.salcorps.beans")
public class ProjectConfig {
    @Bean
    Vehicle vehicle() {
        var veh = new Vehicle();
        veh.setName("Audi");
        return veh;
    }
    @Bean
    Speakers boseSpeakers() {
        Speakers sp = new Speakers();
        sp.setSpeakerName("Bose Speakers");
        return sp;
    }
    @Bean
    @Primary
    Speakers sonySpeakers() {
        Speakers sp = new Speakers();
        sp.setSpeakerName("Sony Speakers");
        return sp;
    }
    @Bean
    @Primary
    Wheels bridgeStoneTyres() {
        Wheels wh = new Wheels();
        wh.setWheelName("BridgeStone Tyres");
        return wh;
    }
    @Bean
    Wheels michelinTyres() {
        Wheels wh = new Wheels();
        wh.setWheelName("Michelin Tyres");
        return wh;
    }
}
