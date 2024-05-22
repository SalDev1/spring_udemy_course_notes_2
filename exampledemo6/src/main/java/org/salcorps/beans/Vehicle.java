package org.salcorps.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    public String name;

//    @Autowired
//    private Person person;
//
//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }

    public String getName() {
        return name;
    }

    public Vehicle() {
        System.out.println("Vehicle bean created by Spring.");
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
