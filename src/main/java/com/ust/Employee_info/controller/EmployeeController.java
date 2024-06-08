package com.ust.Employee_info.controller;

import com.ust.Employee_info.model.Employee;
import com.ust.Employee_info.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addemployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employeeList){
        return employeeService.addEmployees(employeeList);
    }
    @PutMapping("/updateemployee")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }
    @GetMapping("/getemployee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }
    @GetMapping("/getallemployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @DeleteMapping("/deleteemployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }

}
