package com.yash.SpringSecurityEx.controller;

import com.yash.SpringSecurityEx.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/StudentCall")
public class StudentController {


    private List<Student> Details = new ArrayList<>(List.of(
            new Student(1,"Yash",90) ,
            new Student(2,"Yug",90),
            new Student(3,"yagya",80)

    ));

    @GetMapping("/list")
    public List<Student> getStudents(){
        return Details ;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/list")
    public Student addStudent(@RequestBody Student student ){
        Details.add(student);
        return student;
    }
}
