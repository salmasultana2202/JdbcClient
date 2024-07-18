package com.example.jdbcClientDemo.controller;

import com.example.jdbcClientDemo.domain.Student;
import com.example.jdbcClientDemo.domain.StudentRequest;
import com.example.jdbcClientDemo.domain.StudentResponse;
import com.example.jdbcClientDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> allUsers = service.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Integer id){
        StudentResponse studentById = service.getStudentById(id);
        return  new ResponseEntity<>(studentById,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest student) {
        StudentResponse student1 = service.createStudent(student.toStudent());
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentResponse> updateStudent(@RequestBody StudentRequest student, @PathVariable Integer id){
        StudentResponse studentResponse = service.updateStudent(student.toStudent(), id);
        return  new ResponseEntity<>(studentResponse,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
        service.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully",HttpStatus.NO_CONTENT);
    }


}
