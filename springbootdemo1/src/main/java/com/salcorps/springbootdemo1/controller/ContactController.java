package com.salcorps.springbootdemo1.controller;

import com.salcorps.springbootdemo1.model.Contact;
import com.salcorps.springbootdemo1.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContactController {

    private static Logger log = LoggerFactory.getLogger(ContactController.class);
    public ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
        // Injecting the contactService bean into the ContactController Bean
    }

    @RequestMapping(value="/contact")
    public String displayContactPage() {
        return "contact.html";
    }

    //    @RequestMapping(value="/saveMsg",method = RequestMethod.POST)
//    public ModelAndView saveMessage(@RequestParam String name ,
//                                    @RequestParam String mobileNum,
//                                    @RequestParam String email ,
//                                    @RequestParam String subject ,
//                                    @RequestParam String message) {
//        log.info("Name : " + name);
//        log.info("Mobile Number : " + mobileNum);
//        log.info("Email Address : " + email);
//        log.info("Subject : " + subject);
//        log.info("Message : " + message);
//        // The below code helps you to redirect to the contact page again after we capture the user's data.
//        return new ModelAndView("redirect:/contact");
//    }
    @RequestMapping(value="/saveMsg",method= RequestMethod.POST)
    public ModelAndView saveMessage(Contact contact) {
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }
}
