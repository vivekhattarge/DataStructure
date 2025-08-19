package com.java.practise.completableFuture.examples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class PrintEvenOddNumbers {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.rangeClosed(1,10).forEach(
                number -> {
                    CompletableFuture<Integer> completableFutureOdd = CompletableFuture.completedFuture(number)
                            .thenApplyAsync((num) -> {
                                if(num%2 != 0){
                                    System.out.println("Thread name : "+Thread.currentThread().getName() + " => "+num);
                                }
                                return num;
                            },executorService);
                    completableFutureOdd.join();

                    CompletableFuture<Integer> completableFutureEven = CompletableFuture.completedFuture(number)
                            .thenApplyAsync( (num) -> {
                                if(num%2 == 0){
                                    System.out.println("Thread name : "+Thread.currentThread().getName() + " => "+num);
                                }
                                return num;
                            },executorService);
                    completableFutureEven.join();
                }
        );
        executorService.shutdown();
    }
}
