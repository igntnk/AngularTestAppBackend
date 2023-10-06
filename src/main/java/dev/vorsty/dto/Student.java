package dev.vorsty.dto;

import jakarta.persistence.*;

import java.sql.Struct;

@Entity
@Table(name="students")
public class Student {

    public Student() {}

    public Student(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private String surname;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }
}
