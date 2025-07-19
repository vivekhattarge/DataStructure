package com.java.practise;

import java.util.ArrayList;
import java.util.List;

public class DataLake {

    public static List<Employee> saveEmployees(){
       List<Employee> employees = new ArrayList<>();
       employees.add( new Employee(1,"Vivek",50000));
       employees.add( new Employee(2,"Vikram",10000));
       employees.add( new Employee(3,"Vikas",20000));
       employees.add( new Employee(4,"Kabir",30000));
       return employees;
    }
}
