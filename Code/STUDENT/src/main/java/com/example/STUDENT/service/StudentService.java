package com.example.STUDENT.service;

import com.example.STUDENT.entity.Student;
import com.example.STUDENT.repo.IRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private IRepo repo;



    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Student student) {
        repo.save(student);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
