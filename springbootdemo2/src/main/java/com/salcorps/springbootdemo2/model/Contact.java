package com.salcorps.springbootdemo2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name="contact_msg")
public class Contact extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    @Column(name="contact_id")
    private int contactId;

    @NotBlank(message="Name must not be blank")
    @Size(min=3,message="Name must be at least 3 characters long")
    private String name;

    @NotBlank(message="Mobile Num must not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})",message="Name must be at least 3 characters long")
    private String mobileNum;

    @NotBlank(message="Email must not be blank")
    @Email(message="Please provide a valid email address")
    private String email;

    @NotBlank(message = "Subject must not be blank")
    @Size(min=5,message = "Subject must be at least 5 characters long")
    private String subject;

    @NotBlank(message = "Message must not be blank")
    @Size(min=10,message = "Message must be at least 10 characters long")
    private String message;

    private String status;
}