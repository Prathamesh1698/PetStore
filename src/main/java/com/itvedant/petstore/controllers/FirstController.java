package com.itvedant.petstore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
class Student {

    private int id;
    private String name;
    private String email;

    Student(int id, String name, String email) {

        this.id = id;
        this.name = name;
        this.email = email;
    }


}



@RestController
public class FirstController {
    @RequestMapping("/message")

    public String getMessage() {
        return "Welcome to rest API";

    }

    @RequestMapping("/marks")
    public Integer getMarks() {
        return 59;
    }

    @RequestMapping("/student")

    public Student getStudents() {
        return new Student(5, "Pattu", "p@gmail.com");
    }

    @RequestMapping("/studs")

    public List<Student> getStudent() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Patu", "Pk@gmail.com"));
        students.add(new Student(2, "datu", "dk@gmail.com"));
        students.add(new Student(3, "satu", "sk@gmail.com"));
        students.add(new Student(4, "gatu", "gkk@gmail.com"));
        return students;
    }

}


