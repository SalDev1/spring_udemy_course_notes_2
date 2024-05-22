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

    @Bean
    public Vehicle vehicle() {
        var vehicle = new Vehicle();
        vehicle.setName("Audi");
        return vehicle;
    };
   /*
    Here in the below code, we are trying to wire or establish
    a relationship between Person and Vehicle by invoking
    the vehicle() bean method from person() bean method.


    Spring will make sure to have only 1 vehicle bean is created
    and also vehicle bean will be created first always as person
    bean has dependency on it.
   */

    // Wiring using the method call.
    @Bean
    public Person person() {
       var person = new Person();
       person.setName("Lucy");
       person.setVehicle(vehicle());
       return person;
    };

    // Wiring using the method parameter.
    @Bean
    public Person person2(Vehicle vehicle) {
        var person = new Person();
        person.setName("Lucy");
        person.setVehicle(vehicle);
        return person;
    };
}
