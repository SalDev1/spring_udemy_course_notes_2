package org.salcorps.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    // Vehicle is dependent on Speakers and Wheels.
    public String name;
    @Autowired
    public Wheels wheels;
    @Autowired
    public Speakers speakers;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Vehicle() {
        System.out.println("Vehicle Bean is created");
    }

    public String getWheels () {
        return wheels.getWheelName();
    }
    public String getSpeakers() {
        return speakers.getSpeakerName();
    }
}
