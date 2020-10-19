package com.phamtan.do_an.dao.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity(name = "shipper")
@Table(name = "shipper")
@Data
@RequiredArgsConstructor
public class Shipper {
    @Id
    @GeneratedValue
    private long id ;
    private String name ;
    private String vehicle ;
    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;
}
