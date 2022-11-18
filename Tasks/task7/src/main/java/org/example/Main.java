package org.example;

import java.util.concurrent.BrokenBarrierException;

public class Main {
    private static CustomCyclicBarrier cyclicBarrier = new CustomCyclicBarrier(
            () -> System.out.println("Barrier reached"), 3);

    private static void startThreadWithTime(long timeOut){
        new Thread(){
            @Override
            public void run(){
                try {
                    System.out.println("Start");
                    synchronized (this){
                        this.wait(timeOut);
                    }
                    System.out.println("Thread waiting over");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }
    public static void main(String[] args) {
        startThreadWithTime(10000);
        startThreadWithTime(1000);
        startThreadWithTime(2000);
    }
}