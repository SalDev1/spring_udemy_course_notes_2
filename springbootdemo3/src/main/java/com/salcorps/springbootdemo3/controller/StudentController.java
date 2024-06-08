package com.salcorps.springbootdemo3.controller;


import com.salcorps.springbootdemo3.model.Person;
import com.salcorps.springbootdemo3.repository.CoursesRepository;
import com.salcorps.springbootdemo3.repository.EazyClassRepository;
import com.salcorps.springbootdemo3.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("student")
public class StudentController {
    @GetMapping("/displayCourses")
    public ModelAndView displayCourses(Model model , HttpSession session) {
        Person person = (Person) session.getAttribute("loggedInPerson");
        ModelAndView modelAndView = new ModelAndView("courses_enrolled.html");
        modelAndView.addObject("person",person);
        return modelAndView;
    }
}
