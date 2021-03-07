package com.company;

abstract class Account
{
    private String ac_type;
    private double balance;
    private String name;
    private double loan;
    private double pendingLoan;
    private int ac_age;


    Account()
    {
        loan = 0;
        pendingLoan = 0;
        ac_age = 0;
    }

    final double LOAN_INTEREST_RATE = 10.0;

    public String getAc_type() { return ac_type; }
    public void setAc_type(String ac_type) { this.ac_type = ac_type; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getLoan() { return loan; }
    public void setLoan(double loan) { this.loan = loan; }

    public double getPendingLoan() { return pendingLoan; }
    public void setPendingLoan(double pendingLoan) { this.pendingLoan = pendingLoan; }

    public int getAc_age() { return ac_age; }
    public void setAc_age(int ac_age) { this.ac_age = ac_age; }

    @Override
    public String toString() {
        return "Account{" +
                "ac_type='" + ac_type + '\'' +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                ", loan=" + loan +
                ", pendingLoan=" + pendingLoan +
                ", LOAN_INTEREST_RATE=" + LOAN_INTEREST_RATE +
                '}';
    }

    public void addBalance(double amount) { this.balance += amount; }
    public void removeBalance(double amount) { this.balance -= amount; }

    public void addLoan(double amount) { this.loan += amount; }
//    public void removeLoan(double amount) { this.loan += amount; }

    abstract public boolean createAccount(double balance,String name);
    abstract public boolean deposit(double amount);
    abstract public boolean withdraw(double amount);
    abstract public boolean requestLoan(double amount);
}