package com.luv2code.springboot.datajpa.springbootcruddemodatajpa.service;

import com.luv2code.springboot.datajpa.springbootcruddemodatajpa.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> findAll();
    public Optional<Employee> findById(int id);
    public void save(Employee theEmployee);
    public void deleteById(int id);
}
