package com.spring.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "id:"+ this.id + " name:" + name; 
    }
}

/**
 * WishList
 */
class WishList {
    String name;

    public WishList(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class App {

    public static void sleepThread(int seconds) {
        try {
            System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<User> getUserDetails(int id) {
        User user = new User(id, "Manju");
        return CompletableFuture.supplyAsync(() -> {
            sleepThread(2);
            return user;
        });
    }

    public static CompletableFuture<List<WishList>> getWishList(User user) {
        return CompletableFuture.supplyAsync(() -> {
            sleepThread(3);
            List<WishList> wishLists = new ArrayList<WishList>();
            wishLists.add(new WishList("mobile"));
            wishLists.add(new WishList("pad"));
            wishLists.add(new WishList("mobile"));
            return wishLists;
        });
    }

    public static void main(String[] args) throws Exception {
        // composeExample();
        // combineExample();
        // allOfExample();
        anyOfExample();
    }

    private static void composeExample() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        CompletableFuture<List<WishList>> completableFuture = getUserDetails(1)
                .thenCompose(user -> getWishList(user));
        System.out.println("Main Thread");
        sleepThread(5);
        System.out.println("list = " + completableFuture.get());
        long endTime = System.currentTimeMillis();
        System.out.println("Over all time taken = " + ((endTime - startTime) / 1000) + " seconds");
        System.out.println();
    }

    private static void combineExample() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        CompletableFuture<User> completableFuture = getUserDetails(2)
                .thenCombine(getUserDetails(1), (u2, u1) -> {
                    System.out.println("resul1: " + u1);
                    System.out.println("result2: " + u2);
                    return u1;
                });
        System.out.println("Main Thread");
        sleepThread(5);
        System.out.println("User = " + completableFuture.get());
        long endTime = System.currentTimeMillis();
        System.out.println("Over all time taken = " + ((endTime - startTime) / 1000) + " seconds");
        System.out.println("hello");
        System.out.println();
    }

    private static void allOfExample() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        
        CompletableFuture<User> completableFuture = CompletableFuture.allOf(getUserDetails(1), getUserDetails(2), getUserDetails(3), getUserDetails(4))
        .thenCompose((result) -> {
            System.out.println("result=" + result);
            return getUserDetails(5);  
        });
                
        System.out.println("Main Thread");
        sleepThread(5);
        System.out.println("user = " + completableFuture.get());
        long endTime = System.currentTimeMillis();
        System.out.println("Over all time taken = " + ((endTime - startTime) / 1000) + " seconds");
        System.out.println();
    }

    private static void anyOfExample() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        
        CompletableFuture<User> completableFuture = CompletableFuture.anyOf(getUserDetails(1), getUserDetails(2), getUserDetails(3), getUserDetails(4))
        .thenCompose((result) -> {
            System.out.println("result=" + result);
            return getUserDetails(5);  
        });
                
        System.out.println("Main Thread");
        sleepThread(5);
        System.out.println("user = " + completableFuture.get());
        long endTime = System.currentTimeMillis();
        System.out.println("Over all time taken = " + ((endTime - startTime) / 1000) + " seconds");
        System.out.println();
    }
}