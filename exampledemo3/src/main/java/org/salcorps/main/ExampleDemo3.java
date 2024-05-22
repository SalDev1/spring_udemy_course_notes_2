package org.salcorps.main;

import org.salcorps.beans.Vehicle;
import org.salcorps.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class ExampleDemo3 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // Fetching the bean from the Spring IOC Container (Application Context).
        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");

        // Defining an supplier interface ,
        // not taking any input and supply the output.
        Supplier<Vehicle> voklswagenSupplier = () -> volkswagen;

        // Example of Lambda Supplier Interface.
        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle audi = new Vehicle();
            audi.setName("Audi");
            return audi;
        };

        Random random = new Random();
        int randomNumber = random.nextInt(10);

        System.out.println("randomNumber = " + randomNumber);

        if (randomNumber % 2 == 0) {
            context.registerBean("volkswagen", Vehicle.class, voklswagenSupplier);
        } else {
            context.registerBean("audi", Vehicle.class, audiSupplier);
        }

        // Fetching the register bean based on the random number.
        Vehicle volksVehicle = null;
        Vehicle audiVehicle = null;

        try {
            volksVehicle = context.getBean("volkswagen", Vehicle.class);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating Volkswagen vehicle");
        }

        try {
            audiVehicle = context.getBean("audi", Vehicle.class);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating Audi vehicle");
        }

        if (null != volksVehicle) {
            System.out.println("Programming vehicle name from Spring Context is : " + volksVehicle.getName());
        } else {
            System.out.println("Programming vehicle name from Spring Context is : " + audiVehicle.getName());
        }
    }
}
