package org.salcorps.main;

import org.salcorps.beans.Person;
import org.salcorps.beans.Vehicle;
import org.salcorps.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AssignmentDemo1 {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person = context.getBean(Person.class);
        Vehicle vehicle = context.getBean(Vehicle.class);

        System.out.println("Person that owns a vehicle is : " + person.getName());
        System.out.println("Vehicle that person owns is : " + person.getVehicle());
        System.out.println("Speakers that vehicle has is : " + vehicle.getSpeakers());
        System.out.println("Wheels that vehicle has is : " + vehicle.getWheels());
    }
}
