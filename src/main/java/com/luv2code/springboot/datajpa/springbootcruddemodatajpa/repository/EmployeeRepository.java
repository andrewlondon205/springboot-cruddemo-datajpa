package com.luv2code.springboot.datajpa.springbootcruddemodatajpa.repository;

import com.luv2code.springboot.datajpa.springbootcruddemodatajpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
