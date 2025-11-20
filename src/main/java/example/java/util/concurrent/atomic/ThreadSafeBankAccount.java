package example.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeBankAccount {

    private final AtomicInteger balance;
    private final AtomicInteger tranCount = new AtomicInteger(0);

    public ThreadSafeBankAccount(AtomicInteger balance) {
        this.balance = balance;
    }

    public AtomicInteger getTranCount() {
        return tranCount;
    }

    public AtomicInteger getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance.updateAndGet(crrBalance -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            tranCount.incrementAndGet();
            return crrBalance - amount;
        });
    }
}
