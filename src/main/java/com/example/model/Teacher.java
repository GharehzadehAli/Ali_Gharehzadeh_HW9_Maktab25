package com.example.model;



import javax.persistence.*;
import java.io.Serializable;

import java.time.LocalDate;

@Entity
@Table(name = "teachers")
public class Teacher implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher")
    private Address address;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "teacher_code",unique = true)
    private long teacherCode;

    @Column(nullable = false,name = "birth_date")
    private LocalDate date;
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Column(nullable = false,name = "salary")
    private double salary;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, long teacherCode,LocalDate date,float salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacherCode = teacherCode;
        this.date=date;
        this.salary=salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(long teacherCode) {
        this.teacherCode = teacherCode;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "address=" + address.getCity() +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teacherCode=" + teacherCode +
                ", date=" + date +
                ", salary=" + salary +
                '}'+"\n";
    }
}
