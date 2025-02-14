package com.DemoQA.PageLayer;

import org.testng.annotations.Test;

public class TC23_TestNGPriorityExample {

    @Test(priority = -2)
    public void testA() {
        System.out.println("Executing testA with priority -2");
    }

    @Test(priority = -1)
    public void testB() {
        System.out.println("Executing testB with priority -1");
    }

    @Test(priority = 0)
    public void testC() {
        System.out.println("Executing testC with priority 0");
    }

    @Test(priority = 1)
    public void testD() {
        System.out.println("Executing testD with priority 1");
    }

    @Test(priority = 2)
    public void testE() {
        System.out.println("Executing testE with priority 2");
    }
}