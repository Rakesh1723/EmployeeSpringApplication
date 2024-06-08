package com.ust.Employee_info.repository;

import com.ust.Employee_info.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByGrade(Character grade);

    @Query("SELECT e FROM Employee e WHERE e.basicSalary BETWEEN :minSalary AND :maxSalary")
    List<Employee> findEmployeeBySalaryRange(@Param("minSalary") String minSalary, @Param("maxSalary") String maxSalary);

}
