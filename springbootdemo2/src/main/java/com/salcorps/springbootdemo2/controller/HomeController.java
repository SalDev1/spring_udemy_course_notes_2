package com.salcorps.springbootdemo2.controller;


import com.salcorps.springbootdemo2.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    Logger log = LoggerFactory.getLogger(HomeController.class);
    @RequestMapping(value={"","/","/home"})
    public String displayHomePage() {
        return "home.html";
    }
//    @RequestMapping("/courses")
//    public String displayCoursesPage() {
//        return "courses.html";
//    }
//    @RequestMapping("/contact")
//    public String displayContactPage() {
//        return "contact.html";
//    }
//
//    @RequestMapping("/about")
//    public String displayAboutPage() {
//        return "about.html";
//    }

}
