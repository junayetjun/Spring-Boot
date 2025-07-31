package com.example.STUDENT.repo;

import com.example.STUDENT.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepo extends JpaRepository<Student, Long> {
}
