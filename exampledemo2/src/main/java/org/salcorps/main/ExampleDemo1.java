package org.salcorps.main;

import org.salcorps.beans.Vehicle;
import org.salcorps.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ExampleDemo1 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // Fetching the bean from the Spring IOC Container (Application Context).
        Vehicle veh1 = context.getBean(Vehicle.class);
        System.out.println("Component Vehicle name from the Spring Context is : " + veh1.getName());
        veh1.helloWorld();
        context.close();
    }
}
