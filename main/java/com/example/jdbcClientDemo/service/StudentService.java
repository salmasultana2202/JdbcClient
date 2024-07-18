package com.example.jdbcClientDemo.service;

import com.example.jdbcClientDemo.domain.Student;
import com.example.jdbcClientDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;
    public List<Student> getAllUsers() {
        return repository.getAllStudents();
    }
}
