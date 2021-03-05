package com.company;

import java.util.ArrayList;

abstract class Account
{
    private String ac_type;
    private int balance;
    private String name;
    private int loan;

    final double LOAN_INTEREST_RATE = 10.0;

    public String getAc_type() {
        return ac_type;
    }

    public void setAc_type(String ac_type) {
        this.ac_type = ac_type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLoan() {
        return loan;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }

    public boolean pkEnsured(ArrayList<Account> accounts, String name)
    {
        for(Account ac:accounts)
        {
            if(ac.getName()==name)
                return false;
        }

        return true;
    }

    public void addBalance(int amount) { this.balance += amount; }
    public void removeBalance(int amount) { this.balance += amount; }

    public void addLoan(int amount) { this.loan += amount; }
//    public void removeLoan(int amount) { this.loan += amount; }

    abstract public boolean createAccount(int balance,String name);
    abstract public boolean deposit(int amount);
    abstract public boolean withdraw(int amount);
    abstract public boolean requestLoan(int amount);
}

class Savings extends Account
{
    final int MIN_BALANCE = 1000;
    final int MAX_LOAN = 10000;
    static double DEPOSIT_INTEREST_RATE = 10.0;
    double SERVICE_CHARGE = 500.0;

    Savings()
    {
        setAc_type("Savings");
    }

    public boolean createAccount(int balance,String name)
    {
        setBalance(balance);
        setName(name);

        return true;
    }

    public boolean deposit(int amount)
    {
        addBalance(amount);
        return true;
    }

    public boolean withdraw(int amount)
    {
        if(amount > getBalance()) return false;

        if(getBalance()-amount >= MIN_BALANCE)
        {
            removeBalance(amount);
            return true;
        }
        return false;
    }

    public boolean requestLoan(int amount)
    {
        if(getLoan()+amount <= MAX_LOAN)  return true; // loan request valid

        return false;
    }
}

class Student extends Account
{
    final int WITHDRAWAL_LIMIT = 10000;
    final int MAX_LOAN = 1000;
    static double DEPOSIT_INTEREST_RATE = 5.0;

    Student()
    {
        setAc_type("Student");
    }

    public boolean createAccount(int balance,String name)
    {
        setBalance(balance);
        setName(name);

        return true;
    }

    public boolean deposit(int amount)
    {
        addBalance(amount);
        return true;
    }

    public boolean withdraw(int amount)
    {
        if(amount > getBalance()) return false;

        if(amount <= WITHDRAWAL_LIMIT)
        {
            removeBalance(amount);
            return true;
        }

        return false;
    }

    public boolean requestLoan(int amount)
    {
        if(getLoan()+amount <= MAX_LOAN)  return true; // loan request valid

        return false;
    }

}

class Fixed_Deposit extends Account
{
    final int MIN_INIT_DEPOSIT = 100000;
    final int MIN_DEPOSIT = 50000;
    final int MAX_LOAN = 100000;
    static double DEPOSIT_INTEREST_RATE = 15.0;
    final double SERVICE_CHARGE = 500.0;

    Fixed_Deposit()
    {
        setAc_type("Fixed_Deposit");
    }

    static void changeDepositInterestRate(double new_rate) { DEPOSIT_INTEREST_RATE = new_rate; }

    public boolean createAccount(int balance,String name)
    {
        if(balance >= MIN_INIT_DEPOSIT)
        {
            setBalance(balance);
            setName(name);
            return true;
        }

        return false;
    }

    public boolean deposit(int amount)
    {
        if(amount >= MIN_DEPOSIT)
        {
            addBalance(amount);
            return true;
        }

        return false;
    }

    public boolean withdraw(int amount)
    {
        if(amount > getBalance()) return false;

        // need to add the condition of maturity period

        return false;
    }

    public boolean requestLoan(int amount)
    {
        if(getLoan()+amount <= MAX_LOAN)  return true; // loan request valid

        return false;
    }
}


abstract class Employee
{
    private String em_type;

    public String getEm_type() {
        return em_type;
    }

    public void setEm_type(String em_type) {
        this.em_type = em_type;
    }

    public int lookup(Account ac) { return ac.getBalance(); }
    abstract public boolean approveLoan();
    abstract public boolean changeInterestRate();
}

class Managing_Director extends Employee
{
    Managing_Director()
    {
        setEm_type("Managing Director");
    }

    public boolean approveLoan(){return true;}
    public boolean changeInterestRate(String ac_type)
    {

    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here

        ArrayList<Account> accounts = new ArrayList<Account>();

        Savings sv1 = new Savings();
        sv1.createAccount(10,"A");
        accounts.add(sv1);

        Savings sv2 = new Savings();
        sv2.createAccount(10,"B");
        accounts.add(sv2);

        Savings sv3 = new Savings();
        if(sv3.pkEnsured(accounts,"B"))
        {
            sv3.createAccount(10,"B");
            accounts.add(sv3);
        }

        for(Account ac:accounts)
        {
            System.out.println(ac.getName());
        }
    }
}
