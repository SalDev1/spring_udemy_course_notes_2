package com.salcorps.springbootdemo1.service;


import com.salcorps.springbootdemo1.controller.HomeController;
import com.salcorps.springbootdemo1.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

//@Service --> Tells the Spring Container that a class is been
// annotated as service layer.
@Service
@Slf4j
//@RequestScope
//@SessionScope
@ApplicationScope
public class ContactService {
    private int counter = 0;
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    // Save Contact Details to DB.
   // private static Logger log = LoggerFactory.getLogger(HomeController.class);
    public ContactService() {
        System.out.println("Contact Service Bean Initialized");
    }

    public boolean saveMessageDetails(Contact contact){
        System.out.println("contact = " + contact);
        boolean isSaved = true;
        log.info(contact.toString());
        return isSaved;
    }
}
