package org.salcorps.beans;


import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void helloWorld() {
        System.out.println("Printing Hello World from Component Vehicle Bean !");
    }

    @Override
    public String toString() {
        return "Vehicle name is - "+ name;
    }
}
