package example.java.util.concurrent.atomic;


public class NonThreadSafeBankAccount {
    private int balance;
    private int transCount = 0;

    public NonThreadSafeBankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public int getTransCount() {
        return transCount;
    }

    public void withdraw(int amount) {
        assert amount > 0 : "amount must be positive";
        if (balance >= amount) {
            // increase race condition risk
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            balance -= amount;
            transCount++;
        }
    }
}
