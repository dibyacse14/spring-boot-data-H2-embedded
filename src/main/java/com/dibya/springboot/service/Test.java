package com.dibya.springboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Test {
    @Async
    public void runWaitTimer() throws InterruptedException {
        Thread.sleep(10200);
        for(int i =0 ; i<100 ; i++){
            System.out.println(i);
        }
        System.out.println(new Date(System.currentTimeMillis()));
        throw new ArithmeticException("Catch The Exception");
    }
}
