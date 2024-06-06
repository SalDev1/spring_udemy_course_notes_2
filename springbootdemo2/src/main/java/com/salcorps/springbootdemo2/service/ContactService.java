package com.salcorps.springbootdemo2.service;


import com.salcorps.springbootdemo2.constants.EazySchoolConstants;
import com.salcorps.springbootdemo2.controller.HomeController;
import com.salcorps.springbootdemo2.model.Contact;
import com.salcorps.springbootdemo2.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
//        contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
//        contact.setCreatedAt(LocalDateTime.now());

        // It returns the saved contact object once you invoke
        // the save method of contactRepository.
        Contact result = contactRepository.save(contact);
        if(null != result && result.getContactId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField,String sortDir) {

        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());

        Page<Contact> msgPage = contactRepository.findByStatus(
                EazySchoolConstants.OPEN, pageable);
        return msgPage;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy) {
        boolean isUpdated = false;
        // Check if the contact already exists or not.
        Optional<Contact> contact = contactRepository.findById(contactId);

        // update the required params after fetching the contact.
        contact.ifPresent(contact1 -> {
            contact1.setStatus(EazySchoolConstants.CLOSE);
            contact1.setUpdatedBy(updatedBy);
            contact1.setUpdatedAt(LocalDateTime.now());
        });

        // Invoke the save method to reflect the new changes.
        Contact updatedContact =  contactRepository.save(contact.get());
        if(null != updatedContact && updatedContact.getUpdatedBy() != null) {
            isUpdated = true;
        }
        return isUpdated;
    }
}
