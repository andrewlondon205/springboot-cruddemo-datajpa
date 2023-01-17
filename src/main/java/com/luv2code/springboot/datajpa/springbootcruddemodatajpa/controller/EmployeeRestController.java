package com.luv2code.springboot.datajpa.springbootcruddemodatajpa.controller;

import com.luv2code.springboot.datajpa.springbootcruddemodatajpa.entity.Employee;
import com.luv2code.springboot.datajpa.springbootcruddemodatajpa.service.EmployeeServiceImpl;
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

    private final EmployeeServiceImpl employeeService;

    @GetMapping("/employee/all")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id) {
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/addemployee")
    public ResponseEntity<?> addEmployee(Employee employee) {
        employeeService.save(employee);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteemployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateemployee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee theEmployee) {
        employeeService.save(theEmployee);
        return new ResponseEntity<>(theEmployee,HttpStatus.OK);
    }
}
