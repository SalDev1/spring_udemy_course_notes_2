package org.salcorps.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    // Person is dependent on Vehicle
    public String name = "Hannah";

    // Autowired by vehicle
    @Autowired
    private Vehicle vehicle;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getVehicle() {
        return vehicle.getName();
    }
}
