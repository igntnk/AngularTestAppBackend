package dev.vorsty.dto;

import java.sql.Struct;

public class Student {

    public Student() {}

    public Student(Long id, String fio, String group, String phonenumber){
        this.id = id;
        this.fio = fio;
        this.group = group;
        this.phonenumber = phonenumber;
    }

    private String fio;
    private String group;
    private String phonenumber;

    public String getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    public String getFio(){
        return fio;
    }

    public void setFio(String fio){
        this.fio = fio;
    }
    public String getGroup(){
        return group;
    }

    public void setGroup(String group){
        this.group = group;
    }
    public String getPhonenumber(){
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber){
        this.phonenumber = phonenumber;
    }
}
