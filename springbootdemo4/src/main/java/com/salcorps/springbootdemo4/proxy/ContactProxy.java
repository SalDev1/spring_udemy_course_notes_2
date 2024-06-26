package com.salcorps.springbootdemo4.proxy;


import com.salcorps.springbootdemo4.config.ProjectConfiguration;
import com.salcorps.springbootdemo4.model.Contact;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


// This is the configuration where it's purpose is to consume the web
// services by define an interface and inserting all the details regarding it.
@FeignClient(name="contact",url="http://localhost:8080/api/contact", configuration = ProjectConfiguration.class)
public interface ContactProxy {
    @RequestMapping(method= RequestMethod.GET, value = "/getMessagesByStatus")
    @Headers(value="Content-Type: application/json")
    public List<Contact> getMessagesByStatus(@RequestParam("status") String status);
}
