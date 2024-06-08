package com.salcorps.springbootdemo3.controller;


import com.salcorps.springbootdemo3.model.Person;
import com.salcorps.springbootdemo3.service.PersonService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller

// This will act as a prefix for all the paths
// defined inside the PublicController Class.
@RequestMapping("public")
public class PublicController {
    @Autowired
    public
    PersonService personService;

    @RequestMapping(value = "/register",method = {RequestMethod.GET})
    public String displayRegisterPage(Model model) {
        model.addAttribute("person",new Person());
        return "register.html";
    }

    // It persists the data into the database.
    @RequestMapping(value="/createUser",method = {RequestMethod.POST})
    public String createUser(@Valid @ModelAttribute("person") Person person , Errors errors) {
        if(errors.hasErrors()) {
            return "register.html";
        }
        // Goal --> Persisting the data into the database.
        boolean isSaved = personService.createNewPerson(person);
        if(isSaved) {
            return "redirect:/login?register=true";
        }
        else {
            return "register.html";
        }
    }
}
