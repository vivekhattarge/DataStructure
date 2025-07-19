package com.java.practise;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortMapExamples {

    public static void main(String[] args) {
    Map<String,Integer> map = new HashMap<>();

    map.put("eight",8);
    map.put("two",2);
    map.put("ten",10);
    map.put("four",4);

    Map<Employee,Integer> employeeIntegerMap = new HashMap<>();
    employeeIntegerMap.put(new Employee(5, "John", 1),1000);
    employeeIntegerMap.put(new Employee(2, "Doug", 2),5000);
    employeeIntegerMap.put(new Employee(1, "Jack", 3),3000);
    employeeIntegerMap.put(new Employee(3, "Vivek", 3),2000);

    int task = 2;
    switch (task){
        case 1:
            sortMapByKeyPrimitiveType(map);
            break;
        case 2:
            sortMapByKeyCustomClassType(employeeIntegerMap);
            break;

        case 3:
            sortMapByValueCustomClassType(employeeIntegerMap);
            break;
        default:
            printEmployees(employeeIntegerMap);
    }
    }

    private static void printEmployees(Map<Employee, Integer> employeeIntegerMap) {
        System.out.println("Print Employees");
        employeeIntegerMap.entrySet().forEach(System.out::println);
    }

    private static void sortMapByValueCustomClassType(Map<Employee, Integer> employeeIntegerMap) {
        //comparing by value custom class type
        employeeIntegerMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }

    private static void sortMapByKeyCustomClassType(Map<Employee, Integer> employeeIntegerMap) {
        System.out.println("comparing by key custom class type");
        //comparing by key custom class type
        employeeIntegerMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getEmpId))).forEach(System.out::println);
    }

    private static void sortMapByKeyPrimitiveType(Map<String, Integer> map) {
        System.out.println("comparing by key primitive type");
        //comparing by key primitive type
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
    }

}
