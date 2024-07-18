package com.example.jdbcClientDemo.repository;

import com.example.jdbcClientDemo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    JdbcClient jdbcClient;

    public List<Student> getAllStudents() {

        return jdbcClient.sql("select * from student;")
                   .query(Student.class).list();
    }
}
