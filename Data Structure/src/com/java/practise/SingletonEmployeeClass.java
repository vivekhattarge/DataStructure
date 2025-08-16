package com.java.practise;

public class SingletonEmployeeClass {

    private Integer id;
    private String name;


    private static SingletonEmployeeClass INSTANCE;

    private SingletonEmployeeClass(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public static SingletonEmployeeClass getInstance(Integer id, String name){
        if(INSTANCE == null) {
            synchronized (SingletonEmployeeClass.class) {
                if(INSTANCE == null){
                    return new SingletonEmployeeClass(id, name);
                }
            }
        }
        return INSTANCE;
    }

}
