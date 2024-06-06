package com.salcorps.springbootdemo2.controller;

import com.salcorps.springbootdemo2.model.Contact;
import com.salcorps.springbootdemo2.service.ContactService;
import com.salcorps.springbootdemo2.model.Contact;
import com.salcorps.springbootdemo2.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@Slf4j
public class ContactController {

    public ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
        // Injecting the contactService bean into the ContactController Bean
    }

    @RequestMapping(value="/contact")
    public String displayContactPage(Model model) {
        // model will hold an contact attribute handling a new object of Contact containing
        // all the information inserted by the user.
        model.addAttribute("contact", new Contact());
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
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact , Errors errors) {
       if(errors.hasErrors()) {
           log.error("Contact form validation failed due to : " + errors.toString());
           return "contact.html";
       }
       // If the validations are successful , we move over to the service layer.
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }

    // This Controller Method is responsible for display all the messages
    // fetching it from the DB itself.
    @RequestMapping("/displayMessages/page/{pageNum}")
    public ModelAndView contactMessages(Model model, @PathVariable(name="pageNum") int pageNum,
            String sortField, @RequestParam("sortDir") String sortDir) {

        Page<Contact> msgPage = contactService.findMsgsWithOpenStatus(pageNum,sortField,sortDir);
        List<Contact> contactMsgs = msgPage.getContent();
        ModelAndView modelAndView = new ModelAndView("messages.html");


        model.addAttribute("currentPage",pageNum);
        model.addAttribute("totalPages",msgPage.getTotalPages());
        model.addAttribute("totalMsgs",msgPage.getTotalElements());
        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDir",sortDir);
        model.addAttribute("reverseSortDir",sortDir.equals("asc")?"desc":"asc");
        modelAndView.addObject("contactMsgs",contactMsgs);

        return modelAndView;
    }

    @RequestMapping(value = "/closeMsg", method=RequestMethod.GET)
    public String closeMsg(@RequestParam int id , Authentication authentication) {
        contactService.updateMsgStatus(id,authentication.getName());
        return "redirect:/displayMessages/page/1?sortField=name&sortDir=desc";
    }
}
