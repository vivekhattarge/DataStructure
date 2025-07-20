package com.java.practise.completableFuture.examples;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabase {

    public static List<Employee> fetchEmployees() {
       List<Employee> employees = new ArrayList<>();

       employees.add(new Employee("aochterlonyrr@businessinsider.com","50-162-3249","Ashley","Female","Ochterlony","TRUE","TRUE",1,1));
       employees.add(new Employee("aochterlonyrr1@businessinsider.com","51-162-3249","Ashley1","Female","Ochterlony1","TRUE","TRUE",2,2));

       return employees;
    }
}