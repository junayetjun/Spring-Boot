package com.example.CRUD.service;

import com.example.CRUD.entity.Employee;
import com.example.CRUD.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeRepo iEmployeeRepo;

    public List<Employee> getAll(Employee employee){
        return iEmployeeRepo.findAll();
    }

    public void save(Employee employee){
        iEmployeeRepo.save(employee);
    }


}
