package com.example.jdbcClientDemo.service;

import com.example.jdbcClientDemo.domain.Student;
import com.example.jdbcClientDemo.domain.StudentResponse;
import com.example.jdbcClientDemo.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> getAllUsers() {
        log.info("Retrieving details for all students.");
        return repository.getAllStudents();
    }

    public StudentResponse createStudent(Student student) {
        student= repository.createStudent(student);
        log.info("Student details {} inserted successfully", student.toString());
        return student.toStudentResponse();
    }

    public StudentResponse getStudentById(Integer id) {
        log.info("Retrieving details for studentId {}.", id);
        return repository.getStudentById(id).toStudentResponse();
    }

    public StudentResponse updateStudent(Student student,Integer id){
        log.info("updating Student details with Id: {}",id);
        return repository.updateStudent(student,id).toStudentResponse();
    }
    public void deleteStudent(Integer id){
        repository.deleteStudent(id);
        log.info("Deleted student with ID ={}", id);

    }
}
