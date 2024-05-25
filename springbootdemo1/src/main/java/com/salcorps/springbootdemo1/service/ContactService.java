package com.salcorps.springbootdemo1.service;


import com.salcorps.springbootdemo1.controller.HomeController;
import com.salcorps.springbootdemo1.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//@Service --> Tells the Spring Container that a class is been
// annotated as service layer.
@Service
@Slf4j
public class ContactService {
     // Save Contact Details to DB.
   // private static Logger log = LoggerFactory.getLogger(HomeController.class);

    public boolean saveMessageDetails(Contact contact){
        System.out.println("contact = " + contact);
        boolean isSaved = true;
        log.info(contact.toString());
        return isSaved;
    }
}
