package com.basic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
// import javax.persistence.ManyToOne;

@Entity
public class Laptop {

    @Id
    private int lid;
    private String lname;
    // Assuming a many-to-one relationship with Student
    // If Laptop can belong to multiple students, this should be @ManyToMany
    // If Laptop belongs to one student, this is correct
    // @ManyToOne
     @ManyToMany
    private List<Student> student = new ArrayList<>();

    public List<Student> getStudent() {
        return student;
    }
    public void setStudent(List<Student> student) {
        this.student = student;
    }
    public int getLid() {
        return lid;
    }
    public void setLid(int lid) {
        this.lid = lid;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }

}
