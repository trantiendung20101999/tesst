package com.example.test.model;

import java.io.Serializable;

public class StudentInSubject implements Serializable {
    private int idStu;
    private int idSub;
    private String Term;
    private int number;

    public StudentInSubject(int idStu, int idSub, String term, int number) {
        this.idStu = idStu;
        this.idSub = idSub;
        Term = term;
        this.number = number;
    }

    public int getIdStu() {
        return idStu;
    }

    public void setIdStu(int idStu) {
        this.idStu = idStu;
    }

    public int getIdSub() {
        return idSub;
    }

    public void setIdSub(int idSub) {
        this.idSub = idSub;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
