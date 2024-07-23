package com.java.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John", 1));
        employees.add(new Employee(2, "Doug", 2));
        employees.add(new Employee(3, "Jack", 3));
        employees.add(new Employee(4, "Daisy", 4));
        employees.add(new Employee(5, "Vivek", 5));
        employees.add(new Employee(6, "William", 5));

        int task = 2;
        switch (task) {
            case 1:
                // Example 1: Print the employee data using the stream
                printAllEmployees(employees);
                break;
            case 2:
                //Example 2: Print the employee data by sorting employee salaries in descending order.
                printEmplyeesWithDescendingOrderOfTheirSalary(employees);
                break;
            default:
                printAllEmployees(employees);

        }
    }

    private static void printAllEmployees(List<Employee> employees) {
        employees.forEach(System.out::println);
    }

    private static void printEmplyeesWithDescendingOrderOfTheirSalary(List<Employee> employees) {

/*
        Comparator<Employee> employeeSalaryComparator = Comparator.comparing(Employee::getEmpSalary, (e1,e2) -> e2.compareTo(e1));
        employees.sort(employeeSalaryComparator);
        employees.forEach(System.out::println);
*/
        List<Employee> sortedDescOrder =
                employees.stream().sorted((Comparator.comparingLong(Employee::getEmpSalary).thenComparing(Employee::getEmpName)).reversed()).toList();

        sortedDescOrder.forEach(System.out::println);

    }

}