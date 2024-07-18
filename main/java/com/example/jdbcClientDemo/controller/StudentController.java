package com.example.jdbcClientDemo.controller;

import com.example.jdbcClientDemo.domain.Student;
import com.example.jdbcClientDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> allUsers = service.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }



}
