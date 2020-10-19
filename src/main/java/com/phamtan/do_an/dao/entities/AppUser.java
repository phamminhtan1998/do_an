package com.phamtan.do_an.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "user")
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue
    private long id ;
    @Column(nullable = false ,unique = true)
    private String username ;
    private String password ;

}
