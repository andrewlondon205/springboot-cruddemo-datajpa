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
public class EmployeeServiceImpl {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty())
            throw new RuntimeException("The desired resource does not exist");
        return employee.get();
    }

    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    public void deleteById(int id) {
        Optional<Employee> tempEmployee = employeeRepository.findById(id);
        if (tempEmployee.isEmpty())
            throw new RuntimeException("The resource is not present in the database");
        employeeRepository.deleteById(id);
    }
}
