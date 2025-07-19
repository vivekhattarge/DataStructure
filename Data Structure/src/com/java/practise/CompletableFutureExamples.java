package com.java.practise;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExamples {


   public static List<Employee> getEmployees() throws ExecutionException, InterruptedException {

    CompletableFuture<List<Employee>> employeesCompletableFuture = CompletableFuture.supplyAsync( () -> {
            System.out.println("Executed by : "+Thread.currentThread().getName());
            return DataLake.saveEmployees();
        } );
        return employeesCompletableFuture.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("EMPs : "+CompletableFutureExamples.getEmployees());
    }
}
