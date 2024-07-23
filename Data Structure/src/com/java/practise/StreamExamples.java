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

        int task = 5;


        switch (task) {
            case 1:
                // Example 1: Print the employee data using the stream
                printAllEmployees(employees);
                break;
            case 2:
                //Example 2: Print the employee data by sorting employee salaries in descending order.
                printEmplyeesWithDescendingOrderOfTheirSalary(employees);
                break;
            case 3:
                //Example 3: Filter the employee names starting with ‘J’
                printEmplyeesStartsWithJ(employees);
                break;
            case 4:
                //Example 4: Add 10000 to each employee’s salary and print
                addAmountToAllEmpSalary(employees);
                break;
            case 5:
                //Example 5: Return the employee object having max salary
                printMaxSalaryEmployee(employees);
                break;
            default:
                printAllEmployees(employees);

        }
    }

    private static void printMaxSalaryEmployee(List<Employee> employees) {

        Employee maxSalariedEmployee = employees.stream().reduce(((employee1, employee2) -> employee1.getEmpSalary() > employee2.getEmpSalary() ? employee1 : employee2)).get();
        System.out.println(maxSalariedEmployee);
    }

    private static void addAmountToAllEmpSalary(List<Employee> employees) {

        employees.forEach(employee -> employee.setEmpSalary(employee.getEmpSalary() + 10000));
        employees.forEach(System.out::println);
    }

    private static void printEmplyeesStartsWithJ(List<Employee> employees) {
        employees.stream()
                .filter(employee -> employee.empName.startsWith("J"))
                .forEach(System.out::println);
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