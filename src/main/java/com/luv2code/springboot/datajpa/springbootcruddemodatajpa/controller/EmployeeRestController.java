package com.luv2code.springboot.datajpa.springbootcruddemodatajpa.controller;

import com.luv2code.springboot.datajpa.springbootcruddemodatajpa.entity.Employee;
import com.luv2code.springboot.datajpa.springbootcruddemodatajpa.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @GetMapping("/employee/all")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id) {
        Optional<Employee> theEmployee = employeeService.findById(id);
        if (theEmployee.isEmpty())
            throw new RuntimeException("The desired resource does not exist");
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/addemployee")
    public ResponseEntity<?> addEmployee(Employee employee) {
        employeeService.save(employee);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteemployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        Optional<Employee> tempEmployee = employeeService.findById(id);
        if(tempEmployee.isEmpty())
            throw new RuntimeException("Employee id not found - " + id);
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateemployee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee theEmployee) {
        employeeService.save(theEmployee);
        return new ResponseEntity<>(theEmployee,HttpStatus.OK);
    }
}
