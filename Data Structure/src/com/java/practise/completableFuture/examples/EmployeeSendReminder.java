package com.java.practise.completableFuture.examples;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class EmployeeSendReminder {
    public static void main(String[] args) {
       EmployeeSendReminder employeeSendReminder = new EmployeeSendReminder();
       employeeSendReminder.sendReminderToEmployee();
    }

    public CompletableFuture<Void> sendReminderToEmployee(){
        Executor executor=Executors.newFixedThreadPool(5);

        CompletableFuture<Void> completableFuture =
                CompletableFuture.supplyAsync(() ->{
                    System.out.println("fetchEmployee : " + Thread.currentThread().getName());
                    return EmployeeDatabase.fetchEmployees();
                },executor).thenApplyAsync(employees -> {
                    System.out.println("filter new joiner employee  : " + Thread.currentThread().getName());
                    return employees.stream()
                    .filter(employee -> "TRUE".equalsIgnoreCase(employee.getNewJoiner()))
                    .collect(Collectors.toList());
                }).thenApplyAsync((employees) -> {
                    System.out.println("get emails  : " + Thread.currentThread().getName());
                    return employees.stream().map(Employee::getEmail).collect(Collectors.toList());
                }).thenAcceptAsync(emails -> {
                    System.out.println("send email  : " + Thread.currentThread().getName());
                    emails.forEach(EmployeeSendReminder::sendEmail);
                });

        return completableFuture;
    }

    private static void sendEmail(String email) {
        System.out.println("sending training reminder email to : " + email);
    }

}
