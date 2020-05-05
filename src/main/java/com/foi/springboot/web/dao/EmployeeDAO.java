package com.foi.springboot.web.dao;

import org.springframework.stereotype.Repository;

import com.foi.springboot.web.model.Employee;
import com.foi.springboot.web.model.Employees;

@Repository
public class EmployeeDAO 
{
    private static Employees list = new Employees();
    
    static 
    {
        list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta", "guptavel@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Alex", "Kolenchiskey", "AlexNanjappa@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "David", "Kameron", "Davidkuppan@gmail.com"));
    }
    
    public Employees getAllEmployees() 
    {
        return list;
    }
    
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}
