package com.basic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
// import javax.persistence.OneToMany;
// import javax.persistence.OneToOne;


@Entity
public class Student {

    @Id
    private int rollNo;
    private String name;
    private int marks;
    // One-to-many relationship with laptop
    @ManyToMany(mappedBy = "student") // Assuming Laptop has a field for Student
    // If you want a one-to-one relationship, you would use @OneToOne instead
    // @OneToOne
    // private Laptop laptop;
    private List<Laptop> laptops = new ArrayList<>();

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + "]";
    }

}
