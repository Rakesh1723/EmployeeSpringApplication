package com.ust.Employee_info.service;

import com.ust.Employee_info.model.Employee;
import com.ust.Employee_info.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;
    public List<Employee> addEmployees(List<Employee> employeeList) {
      return repo.saveAll(employeeList);
    }
    public Employee getEmployee(int id) {
        return repo.findById(id).orElse(null);
    }

    public String deleteEmployee(int id) {
        repo.deleteById(id);
        return "employee deleted with id"+id;
    }
    public Employee updateEmployee(int id, Employee employee) {
        Employee existingEmployee = repo.findById(id).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setGrade(employee.getGrade());
        existingEmployee.setBasicSalary(employee.getBasicSalary());
        repo.save(existingEmployee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }
}
