package com.salcorps.springbootdemo1.service;


import com.salcorps.springbootdemo1.EazySchoolApplication;
import com.salcorps.springbootdemo1.constants.EazySchoolConstants;
import com.salcorps.springbootdemo1.controller.HomeController;
import com.salcorps.springbootdemo1.model.Contact;
import com.salcorps.springbootdemo1.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;

//@Service --> Tells the Spring Container that a class is been
// annotated as service layer.
@Service
@Slf4j
public class ContactService {
    // Save Contact Details to DB.
   // private static Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ContactRepository contactRepository;

    public ContactService() {
        System.out.println("Contact Service Bean Initialized");
    }

    public boolean saveMessageDetails(Contact contact){
        //System.out.println("contact = " + contact);
        boolean isSaved = true;
        contact.setStatus(EazySchoolConstants.OPEN);
        contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if(result > 0) {
            isSaved = true;
        }
        return isSaved;
    }
}
