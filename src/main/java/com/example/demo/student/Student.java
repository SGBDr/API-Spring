package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private Long id = 1L;
    private String name;
    private LocalDate dob;
    private String email;
    @Transient
    private Integer age;

    public Student(){}

    public Student(Long id, String name, LocalDate dob, String email){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Student(String name, LocalDate dob, String email){
        this.name = name;
        this.dob = dob;
        this.email = email;
    }


    public void setAge(Integer age) {
        this.age = age;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
    public LocalDate getDob() {
        return dob;
    }
    public String getEmail() {
        return email;
    
    }
    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", dob=" + dob + ", email=" + email + ", id=" + id + ", name=" + name + "]";
    }
    
}
