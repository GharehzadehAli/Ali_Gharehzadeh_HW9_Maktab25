package com.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {
    public Address(){}
    public Address(String city,String state,String number,String postalAddress,String postalCode){
        this.city=city;
        this.state=state;
        this.number=number;
        this.postalAddress=postalAddress;
        this.postalCode=postalCode;
    }
    @OneToOne(mappedBy = "address")
    Teacher teacher;
    @OneToOne(mappedBy = "address")
    Student student;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "number",nullable = false,unique = true)
    private String number;
    @Column(name = "postalAddress")
    private String postalAddress;
    @Column(name = "postalCode")
    private String postalCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
