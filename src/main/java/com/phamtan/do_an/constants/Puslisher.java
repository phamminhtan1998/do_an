package com.phamtan.do_an.constants;

import javax.persistence.*;

@Entity(name = "publisher")
@Table(name = "publisher")
public class Puslisher {

    @Id
    @GeneratedValue
    private long id ;
    @Column(name = "name")
    private String name ;

    public Puslisher() {
    }

    Puslisher(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
