package org.salcorps.main;

import org.salcorps.beans.Person;
import org.salcorps.beans.Vehicle;
import org.salcorps.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class ExampleDemo4 {
    public static void main(String[] args) {
      var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
      Person person = context.getBean("person2",Person.class);
      Vehicle vehicle = context.getBean(Vehicle.class);

        System.out.println("Person name from Spring Context is : " + person.getName());
        System.out.println("Vehicle name from Spring Context is : " + vehicle.getName());
        System.out.println("Vehicle that Person own is : " + person.getVehicle());
    }
}
