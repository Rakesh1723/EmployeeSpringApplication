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

    public Employee addEmployee(Employee employee) {
        return repo.save(employee);
    }

    public List<Employee> addEmployees(List<Employee> employeeList) {
      return repo.saveAll(employeeList);
    }

    public Employee updateEmployee(int id, Employee employee) {
        Employee existingEmployee = repo.findById(id).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setGrade(employee.getGrade());
        existingEmployee.setBasicSalary(employee.getBasicSalary());
        repo.save(existingEmployee);
        return employee;
    }

    public Employee getEmployee(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public List<Employee> getEmployeeByGrade(Character grade) {
         return repo.findByGrade(grade);
    }

    public List<Employee> getEmployeeBySalaryRange(String minSalary, String maxSalary) {
         return repo.findEmployeeBySalaryRange(minSalary,maxSalary);
    }

    public String deleteEmployee(int id) {
        repo.deleteById(id);
        return "employee deleted with id"+id;
    }
}
