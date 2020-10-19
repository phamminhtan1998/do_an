package com.phamtan.do_an.dao.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "customer")
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue
    private long id ;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    private String last_name;
    private String street;
    private String city ;
    @Column(name = "phone_number",unique = true,nullable = false)
    private String phoneNumber;
    private int age;
    private String sex;
    @Column(name = "email",unique = true,nullable = false)
    private String email;

}
