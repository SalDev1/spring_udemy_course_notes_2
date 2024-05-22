package org.salcorps.main;

import org.salcorps.beans.Vehicle;
import org.salcorps.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ExampleDemo1 {
    public static void main(String[] args) {
        Vehicle veh = new Vehicle();
        veh.setName("Honda City");

        System.out.println("Vehicle name from non-spring context is : " + veh.getName());

        // Defining the container + passing in the class where we have defined our configuration
        // with @Configuration.
        //
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Fetching the bean from the Spring IOC Container (Application Context).
        Vehicle veh1 = context.getBean("lamboVehicle",Vehicle.class);
        System.out.println("Vehicle name from the Spring Context is : " + veh1.getName());

        Vehicle veh2 = context.getBean(Vehicle.class);
        System.out.println("Primary Vehicle name from the Spring Context is : " + veh2.getName());

        String hello = context.getBean(String.class);
        System.out.println("String value from Spring Context is : " + hello);

        Integer num = context.getBean(Integer.class);
        System.out.println("Integer value from Spring Context is : " + num);
    }
}
