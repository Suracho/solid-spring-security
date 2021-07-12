package com.example.security.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private static final List<Student> students = Arrays.asList(
            new Student(1,"Suracho"),
            new Student(2,"Faye dsouza"),
            new Student(3,"malaika arora")
    );

    @GetMapping(path="{studentId}")
    public Student getStudent(@PathVariable("studentId")Integer studentId){
        return students.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Student "+ studentId + "does not exists"));
    }
}
