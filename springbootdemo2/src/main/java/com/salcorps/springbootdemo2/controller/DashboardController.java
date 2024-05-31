package com.salcorps.springbootdemo2.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {

    // We are trying to identify the username and its roles of the verified user.
    @RequestMapping("/dashboard")
    public String displayDashboard(Model model , Authentication authentication) {
        System.out.println(authentication);
        model.addAttribute("username",authentication.getName());
        model.addAttribute("roles",authentication.getAuthorities().toString());

       // throw new RuntimeException("It's been a bad day !");
        return "dashboard.html";
    }
}
