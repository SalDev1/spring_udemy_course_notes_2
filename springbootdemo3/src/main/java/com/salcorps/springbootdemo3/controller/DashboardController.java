package com.salcorps.springbootdemo3.controller;


import com.salcorps.springbootdemo3.model.Person;
import com.salcorps.springbootdemo3.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {

    @Autowired
    PersonRepository personRepository;

    // We are trying to identify the username and its roles of the verified user.
    @RequestMapping("/dashboard")
    public String displayDashboard(Model model , Authentication authentication, HttpSession session) {
        Person person = personRepository.readByEmail(authentication.getName());

        System.out.println(authentication);
        model.addAttribute("username",authentication.getName());
        model.addAttribute("roles",authentication.getAuthorities().toString());

       // throw new RuntimeException("It's been a bad day !");

        // This session will be used in the profileController.
        session.setAttribute("loggedInPerson",person);
        return "dashboard.html";
    }
}
