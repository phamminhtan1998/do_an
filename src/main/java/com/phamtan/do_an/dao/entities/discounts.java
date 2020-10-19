package com.phamtan.do_an.dao.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "discount")
@Table(name = "discount")
@Data
@RequiredArgsConstructor
public class discounts {
    @Id
    @GeneratedValue
    private long id ;
    private String name ;
    private int value ;
}
