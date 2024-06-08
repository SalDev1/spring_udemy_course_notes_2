package com.salcorps.springbootdemo3.rest;


import com.salcorps.springbootdemo3.constants.EazySchoolConstants;
import com.salcorps.springbootdemo3.model.Contact;
import com.salcorps.springbootdemo3.model.Response;
import com.salcorps.springbootdemo3.repository.ContactRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
// The below annotation ensures that the response it generates can be in JSON or XML format.
@RequestMapping(path="/api/contact",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
@CrossOrigin("*")
public class ContactRestController {
    @Autowired
    ContactRepository contactRepository;
    @GetMapping("/getMessagesByStatus")
  //  @ResponseBody
    public List<Contact> getMessagesByStatus(@RequestParam(name="status") String status) {
        return contactRepository.findByStatus(status);
    }
    @GetMapping("/getAllMsgsByStatus")
   // @ResponseBody
    public List<Contact> getAllMsgsByStatus(@RequestBody Contact contact) {
        if(null != contact && null != contact.getStatus()) {
            return contactRepository.findByStatus(contact.getStatus());
        } else {
          return List.of();
        }
    }
    @PostMapping("/saveMsg")
    public ResponseEntity<Response> saveMsg(@RequestHeader("invocationForm") String invocationForm, @Valid @RequestBody Contact contact) {
        log.info(String.format("Header invocationForm = %s", invocationForm));
        contactRepository.save(contact);
        Response response = new Response();
        response.setStatusCode("200");
        response.setStatusMsg("Message saved successfully");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("isMsgSaved","true")
                .body(response);

    }
    @DeleteMapping("/deleteMsg")
    public ResponseEntity<Response> deleteMsg(RequestEntity<Contact> requestEntity) {
        HttpHeaders headers = requestEntity.getHeaders();
        headers.forEach((key,value) -> {
            log.info(String.format(
                    "Header '%s' = %s",key,value.stream().collect(Collectors.toList())
            ));
        });
        Contact contact = requestEntity.getBody();
        contactRepository.deleteById(contact.getContactId());
        Response response = new Response();
        response.setStatusCode("200");
        response.setStatusMsg("Message successfully deleted");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/closeMsg")
    public ResponseEntity<Response> closeMsg(@RequestBody Contact contactReq) {
        Response response = new Response();
        Optional<Contact> contact = contactRepository.findById(contactReq.getContactId());
        if(contact.isPresent()) {
            contact.get().setStatus(EazySchoolConstants.CLOSE);
            contactRepository.save(contact.get());
        } else {
            response.setStatusCode("400");
            response.setStatusMsg("Invalid Contact ID receieved");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        response.setStatusCode("200");
        response.setStatusMsg("Message successfully closed");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
