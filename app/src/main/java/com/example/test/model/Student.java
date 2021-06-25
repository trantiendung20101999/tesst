package com.example.test.model;

import java.io.Serializable;

public class Student implements Serializable {
    private  int id ;
    private  String fullName;
    private String Year;
    private String Address;
    private String Term;

    public Student(int id, String fullName, String year, String address, String term) {
        this.id = id;
        this.fullName = fullName;
        Year = year;
        Address = address;
        Term = term;
    }

    public Student(String fullName, String year, String address, String term) {
        this.fullName = fullName;
        Year = year;
        Address = address;
        Term = term;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }
}
