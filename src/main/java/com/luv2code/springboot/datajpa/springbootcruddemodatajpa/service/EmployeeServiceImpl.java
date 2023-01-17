package com.luv2code.springboot.datajpa.springbootcruddemodatajpa.service;

import com.luv2code.springboot.datajpa.springbootcruddemodatajpa.entity.Employee;
import com.luv2code.springboot.datajpa.springbootcruddemodatajpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }


    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }
    
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
