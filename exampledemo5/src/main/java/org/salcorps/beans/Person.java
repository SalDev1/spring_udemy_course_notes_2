package org.salcorps.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    @Autowired
    public Person(Vehicle vehicle) {
        System.out.println("Person bean created by Spring");
        this.vehicle = vehicle;
    }

    private String name = "Lucy";

    // Autowiring by field
    // @Autowired(required = false)
    // private Vehicle vehicle;
    private Vehicle vehicle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    // Auto-wiring using the setter method.
    // @Autowired
    // public void setVehicle(Vehicle vehicle) {
    // this.vehicle = vehicle;
    // }
}
