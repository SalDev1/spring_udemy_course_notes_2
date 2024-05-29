package com.salcorps.springbootdemo1.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.EAN;

@Data
public class Contact extends BaseEntity{
    private int contactId;

    @NotBlank(message="Name must not be blank")
    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    @NotBlank(message = "Mobile number must not be blank")
    @Pattern(regexp="(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
    private String mobileNum;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message="Subject must not be blank")
    @Size(min=5, message = "Subject must be at least 5 characters long")
    private String subject;

    @NotBlank(message="Message must be not blank")
    @Size(min=10, message = "Message must be at least 10 characters long")
    private String message;

    private String status;

}
