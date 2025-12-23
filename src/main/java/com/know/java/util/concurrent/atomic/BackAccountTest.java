package com.know.java.util.concurrent.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class BackAccountTest {
    //region Test Code
    public static void main(String[] args) throws InterruptedException {
        final int numOfThreads = 10;
        final int initBalance = 10000;
        final int withdrawAmount = 100;
        final int WITHDRAWALS_PER_THREAD = 10;

        testNonSafe(numOfThreads, initBalance, WITHDRAWALS_PER_THREAD, withdrawAmount);
        System.out.println("====================");
        ThreadSafeBankAccount account = new ThreadSafeBankAccount(new AtomicInteger(initBalance));
        BackAccountTest test = new BackAccountTest();
        test.testSafeBankAccount(account, numOfThreads, WITHDRAWALS_PER_THREAD, withdrawAmount);
    }

    private static void testNonSafe(int numOfThreads, int initBalance, int WITHDRAWALS_PER_THREAD, int withdrawAmount) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(numOfThreads);

        NonThreadSafeBankAccount acc = new NonThreadSafeBankAccount(initBalance);

        System.out.println("Initial balance: " + acc.getBalance());
        System.out.println("num of threads: " + numOfThreads);

        // withdraw concurrently by multiple threads
        for (int i = 0; i < numOfThreads; i++) {
            new Thread(() -> {
                for (int j = 0; j < WITHDRAWALS_PER_THREAD; j++) {
                    acc.withdraw(withdrawAmount);
                }
                latch.countDown();
            }).start();
        }

        latch.await();
        System.out.println("Final balance: " + acc.getBalance());
        System.out.println("Total transactions: " + acc.getTransCount());
        System.out.println("Expected balance: " + (initBalance - numOfThreads * WITHDRAWALS_PER_THREAD * withdrawAmount));
    }

    private void testSafeBankAccount(ThreadSafeBankAccount account, int numOfThreads, int WITHDRAWALS_PER_THREAD, int withdrawAmount) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(numOfThreads);

        // withdraw concurrently by multiple threads
        for (int i = 0; i < numOfThreads; i++) {
            new Thread(() -> {
                for (int j = 0; j < WITHDRAWALS_PER_THREAD; j++) {
                    account.withdraw(withdrawAmount);
                }
                latch.countDown();
            }).start();
        }
        latch.await();

        System.out.println("Final balance: " + account.getBalance());
        System.out.println("Total transactions: " + account.getTranCount());
        System.out.println("Expected balance: " + (10000 - numOfThreads * WITHDRAWALS_PER_THREAD * withdrawAmount));
    }
}
