package com.learning.examples.lambdas;

public class RunnableLambdaDemo {

    public static void main(String[] args) {

        // Before Java8
        Runnable runnable  = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable before Java8");
            }
        };
        new Thread(runnable).start();

        // Lambda
        Runnable runnableLambda = () -> {
            System.out.println("Runnable lambda with Java8");
        };
        new Thread(runnableLambda).start();

        Runnable runnableLambda1Liner = () -> System.out.println("Runnable lambda one liner");
        new Thread(runnableLambda1Liner).start();

        new Thread(() -> System.out.println("Runnable lambda embedded")).start();
    }
}
