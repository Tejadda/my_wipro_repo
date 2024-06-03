package com.DAY_23;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized method to deposit money
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". Current balance: " + balance);
    }

    // Synchronized method to withdraw money
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". Current balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + " but insufficient funds. Current balance: " + balance);
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}

class DepositTask implements Runnable {
    private final BankAccount account;
    private final double amount;

    public DepositTask(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(amount);
            try {
                Thread.sleep(100); // Simulate time taken to perform the deposit
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class WithdrawTask implements Runnable {
    private final BankAccount account;
    private final double amount;

    public WithdrawTask(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(amount);
            try {
                Thread.sleep(150); // Simulate time taken to perform the withdrawal
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread depositThread1 = new Thread(new DepositTask(account, 200), "DepositThread1");
        Thread depositThread2 = new Thread(new DepositTask(account, 150), "DepositThread2");
        Thread withdrawThread1 = new Thread(new WithdrawTask(account, 100), "WithdrawThread1");
        Thread withdrawThread2 = new Thread(new WithdrawTask(account, 250), "WithdrawThread2");

        depositThread1.start();
        depositThread2.start();
        withdrawThread1.start();
        withdrawThread2.start();

        try {
            depositThread1.join();
            depositThread2.join();
            withdrawThread1.join();
            withdrawThread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}

