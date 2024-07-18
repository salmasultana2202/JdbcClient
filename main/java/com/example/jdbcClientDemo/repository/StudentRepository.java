package com.example.jdbcClientDemo.repository;

import com.example.jdbcClientDemo.domain.Student;
import com.example.jdbcClientDemo.domain.StudentResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@Slf4j
public class StudentRepository {

    @Autowired
    JdbcClient jdbcClient;

    public List<Student> getAllStudents() {
        return jdbcClient.sql("select * from student;").query(Student.class).list();
    }

    public Student getStudentById(Integer id) {
        Optional<Student> student = jdbcClient.sql("select * from student where id =:id;").param("id", id).query(Student.class).optional();
        if(student.isEmpty()){
            throw new RuntimeException("Student with given Id doesn't exist.");
        }
        return student.get();
    }

    public Student createStudent(Student student) {
        String query = "insert into student(name,age,grade) values(:name,:age,:grade)";
        KeyHolder key = new GeneratedKeyHolder();
        int studentCount = jdbcClient.sql(query).param("name", student.getName()).param("age", student.getAge()).param("grade", student.getGrade()).update(key);
        BigInteger keyId = key.getKeyAs(BigInteger.class);
        student.setId(keyId.intValue());
        return student;
    }

    public Student updateStudent(Student student, Integer id) {
        student = getStudentById(id);
        if (Objects.isNull(student)) {
            log.info("No student found with Id = {}", id);
            throw new RuntimeException("Student with Id " + id + " doesn't exist.");
        }
        jdbcClient.sql("update student set name=:name,age=:age,grade=:grade where id=:id;").param("id", id).param("name", student.getName()).param("age", student.getAge()).param("grade", student.getGrade()).update();
        student.setId(id);
        return student;
    }

    public void deleteStudent(Integer id) {
        jdbcClient.sql("delete from student where id=:id").param("id", id).update();
    }
}
