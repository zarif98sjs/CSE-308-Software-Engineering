/*
*
* Pending Tasks
* - CLOCK
* - withdrawal condition with clock for fixed deposit
* - loan interest rate calc with INC
*
* 
* */

package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
* Bank
* */

class Bank
{
    private double fund;
    ArrayList<Account> accounts;
    ArrayList<Employee> employees;

    final double INIT_FUND = 1000000;

    Bank()
    {
        fund = INIT_FUND;
        accounts = new ArrayList<Account>();
        employees = new ArrayList<Employee>();

        Managing_Director MD = new Managing_Director("MD");
        Officer O1 = new Officer("O1");
        Officer O2 = new Officer("O2");
        Cashier C1 = new Cashier("C1");
        Cashier C2 = new Cashier("C2");
        Cashier C3 = new Cashier("C3");
        Cashier C4 = new Cashier("C4");
        Cashier C5 = new Cashier("C5");

        employees.add(MD);
        employees.add(O1);
        employees.add(O2);
        employees.add(C1);
        employees.add(C2);
        employees.add(C3);
        employees.add(C4);
        employees.add(C5);
    }

    public double getFund() { return fund; }
    public void setFund(double fund) { this.fund = fund; }

    boolean isEmployee(String name)
    {
        for(Employee e:employees)
        {
            if(name.equals(e.getName()))
            {
                return true;
            }
        }
        return false;
    }

    Object getPeople(String name)
    {
        for(Employee e:employees)
        {
            if(name.equals(e.getName()))
            {
                return (Employee)e;
            }
        }

        for(Account ac:accounts)
        {
            if(name.equals(ac.getName()))
            {
                return (Account)ac;
            }
        }

        return null;
    }

    public boolean isLoanPending()
    {
        for(Account ac:accounts)
        {
            if(ac.getPendingLoan()>0)
            {
                return true;
            }
        }
        return false;
    }

    public void approveLoan()
    {
        for(Account ac:accounts)
        {
            double p = ac.getPendingLoan();
            if( p > 0 && fund-p >0)
            {
                ac.addLoan(p);
                ac.addBalance(p);
                ac.setPendingLoan(0.0);
                System.out.println("Loan approved for "+ac.getName());

                fund -= p; // update bank fund
            }
        }
    }
}

/*
 * Account
 * */


abstract class Account
{
    private String ac_type;
    private double balance;
    private String name;
    private double loan;
    private double pendingLoan;

    Account()
    {
        loan = 0;
        pendingLoan = 0;
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

    public boolean pkEnsured(ArrayList<Account> accounts, String name)
    {
        for(Account ac:accounts)
        {
            if(ac.getName()==name)
                return false;
        }

        return true;
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

class Savings extends Account
{
    final double MIN_BALANCE = 1000;
    final double MAX_LOAN = 10000;
    static double DEPOSIT_INTEREST_RATE = 10.0;
    double SERVICE_CHARGE = 500.0;

    Savings()
    {
        setAc_type("Savings");
    }

    static void changeDepositInterestRate(double new_rate){ DEPOSIT_INTEREST_RATE = new_rate;};

    public boolean createAccount(double balance,String name)
    {
        setBalance(balance);
        setName(name);

        return true;
    }

    public boolean deposit(double amount)
    {
        addBalance(amount);
        return true;
    }

    public boolean withdraw(double amount)
    {
        if(amount > getBalance()) return false;

        if(getBalance()-amount >= MIN_BALANCE)
        {
            removeBalance(amount);
            return true;
        }
        return false;
    }

    public boolean requestLoan(double amount)
    {
        if(getLoan()+getPendingLoan()+amount <= MAX_LOAN)
        {
            setPendingLoan(getPendingLoan()+amount);
            return true; // loan request valid
        }
        return false;
    }
}

class Student extends Account
{
    final double WITHDRAWAL_LIMIT = 10000;
    final double MAX_LOAN = 1000;
    static double DEPOSIT_INTEREST_RATE = 5.0;

    Student()
    {
        setAc_type("Student");
    }

    static void changeDepositInterestRate(double new_rate){ DEPOSIT_INTEREST_RATE = new_rate;};

    public boolean createAccount(double balance,String name)
    {
        setBalance(balance);
        setName(name);

        return true;
    }

    public boolean deposit(double amount)
    {
        addBalance(amount);
        return true;
    }

    public boolean withdraw(double amount)
    {
        if(amount > getBalance()) return false;

        if(amount <= WITHDRAWAL_LIMIT)
        {
            removeBalance(amount);
            return true;
        }

        return false;
    }

    public boolean requestLoan(double amount)
    {
        if(getLoan()+getPendingLoan()+amount <= MAX_LOAN)
        {
            setPendingLoan(getPendingLoan()+amount);
            return true; // loan request valid
        }

        return false;
    }

}

class Fixed_Deposit extends Account
{
    final double MIN_INIT_DEPOSIT = 100000;
    final double MIN_DEPOSIT = 50000;
    final double MAX_LOAN = 100000;
    static double DEPOSIT_INTEREST_RATE = 15.0;
    final double SERVICE_CHARGE = 500.0;

    Fixed_Deposit()
    {
        setAc_type("Fixed_Deposit");
    }

    static void changeDepositInterestRate(double new_rate) { DEPOSIT_INTEREST_RATE = new_rate; }

    public boolean createAccount(double balance,String name)
    {
        if(balance >= MIN_INIT_DEPOSIT)
        {
            setBalance(balance);
            setName(name);
            return true;
        }

        return false;
    }

    public boolean deposit(double amount)
    {
        if(amount >= MIN_DEPOSIT)
        {
            addBalance(amount);
            return true;
        }

        return false;
    }

    public boolean withdraw(double amount)
    {
        if(amount > getBalance()) return false;

        // need to add the condition of maturity period

        return false;
    }

    public boolean requestLoan(double amount)
    {
        if(getLoan()+getPendingLoan()+amount <= MAX_LOAN)
        {
            setPendingLoan(getPendingLoan()+amount);
            return true; // loan request valid
        }
        return false;
    }
}

/*
*
* EMPLOYEE
*
* */

abstract class Employee
{
    private String em_type;
    private String name;

    public String getEm_type() {
        return em_type;
    }
    public void setEm_type(String em_type) {
        this.em_type = em_type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "em_type='" + em_type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public double lookup(Account ac) { return ac.getBalance(); }
    abstract public boolean canApproveLoan();
    abstract public boolean changeInterestRate(String ac_type,double new_rate);
    abstract public boolean canSeeInternalFund();
}

class Managing_Director extends Employee
{
    Managing_Director(String name)
    {
        setEm_type("Managing Director");
        setName(name);
    }

    public boolean canApproveLoan(){return true;}
    public boolean changeInterestRate(String ac_type,double new_rate)
    {
        if(ac_type=="Savings")
        {
            Savings.changeDepositInterestRate(new_rate);
        }
        else if(ac_type=="Student")
        {
            Student.changeDepositInterestRate(new_rate);
        }
        else if(ac_type=="Fixed_Deposit")
        {
            Fixed_Deposit.changeDepositInterestRate(new_rate);
        }

        return true;
    }

    public boolean canSeeInternalFund() { return true; }
    public double seeInternalFund(Bank b) { return b.getFund(); }
}

class Officer extends Employee
{
    Officer(String name)
    {
        setEm_type("Officer");
        setName(name);
    }

    public boolean canApproveLoan(){ return true; }
    public boolean changeInterestRate(String ac_type,double new_rate) { return false; }

    public boolean canSeeInternalFund() { return false; }
}

class Cashier extends Employee
{
    Cashier(String name)
    {
        setEm_type("Cashier");
        setName(name);
    }

    public boolean canApproveLoan(){ return false; }
    public boolean changeInterestRate(String ac_type,double new_rate) { return false; }

    public boolean canSeeInternalFund() { return false; }
}

public class Main {

    public static void main(String[] args) {
	// write your code here

        Bank b = new Bank();

//        Savings sv1 = new Savings();
//        sv1.createAccount(10,"A");
//        b.accounts.add(sv1);
//
//        Savings sv2 = new Savings();
//        sv2.createAccount(10,"B");
//        b.accounts.add(sv2);
//
//        Savings sv3 = new Savings();
//        if(sv3.pkEnsured(b.accounts,"B"))
//        {
//            sv3.createAccount(10,"B");
//            b.accounts.add(sv3);
//        }
//
//        for(Account ac:b.accounts)
//        {
//            System.out.println(ac.getName());
//        }

        Object people = null;
        Employee curEmployee = null;
        Account curAccount = null;

        boolean isEmployeeLoggedIn = false;

        while(true)
        {
            Scanner sc= new Scanner(System.in);
            String input = sc.nextLine();
            StringTokenizer tokens = new StringTokenizer(input);
            ArrayList<String>commands = new ArrayList<String>();

            while (tokens.hasMoreTokens())
            {
                commands.add(tokens.nextToken());
            }

            String command = commands.get(0);

            if(command.equals("Create"))
            {
                String name = commands.get(1);
                String ac_type = commands.get(2);
                String init_balance_s = commands.get(3);
                double init_balance = Double.parseDouble(init_balance_s);

                Account ac = null;

                if(ac_type.equals("Student")) { ac = new Student(); }
                else if(ac_type.equals("Savings")) { ac = new Savings(); }
                else if(ac_type.equals("Fixed_Deposit")) { ac = new Fixed_Deposit(); }

                ac.createAccount(init_balance,name);
                b.accounts.add(ac);
                System.out.println(ac_type+" account for "+name+" Created; initial balance "+init_balance+"$");
//                System.out.println(ac);

                curAccount = ac;
                isEmployeeLoggedIn = false;
            }
            if(command.equals("Open"))
            {
                String name = commands.get(1);

                if(b.isEmployee(name))
                {
                    curEmployee = (Employee)b.getPeople(name);
                    isEmployeeLoggedIn = true;

                    System.out.print(name + " Active,");

                    if(b.isLoanPending())
                    {
                        System.out.println("There are loans pending");
                    }
                    else
                    {
                        System.out.println("There are no loans pending");
                    }
                }
                else
                {
                    curAccount = (Account)b.getPeople(name);
                    isEmployeeLoggedIn = false;
                }
            }
            if(command.equals("Deposit"))
            {
                String amount_s = commands.get(1);
                double amount = Double.parseDouble(amount_s);

                if(!isEmployeeLoggedIn)
                {
                    if(curAccount.deposit(amount))
                    {
                        System.out.println(amount+"$ deposited; current balance "+curAccount.getBalance()+"$");
//                        System.out.println(curAccount);
                    }
                    else
                    {
                        /*
                            handle time
                        * */
                        System.out.println("Failed to Deposit");
                    }
                }
                else if(isEmployeeLoggedIn)
                {
                    System.out.println("You are in employee account , login from customer account");
                }
            }
            if(command.equals("Withdraw"))
            {
                String amount_s = commands.get(1);
                double amount = Double.parseDouble(amount_s);

                if(!isEmployeeLoggedIn)
                {
                    if(curAccount.withdraw(amount))
                    {
                        System.out.println(amount+"$ Withdrawn ; current balance "+curAccount.getBalance()+"$");
                    }
                    else
                    {
                        System.out.println("Invalid Transaction; current balance "+curAccount.getBalance()+"$");
                    }
                }
                else if(isEmployeeLoggedIn)
                {
                    System.out.println("You are in employee account , login from customer account");
                }
            }
            if(command.equals("Request"))
            {
                String amount_s = commands.get(1);
                double amount = Double.parseDouble(amount_s);


                if(!isEmployeeLoggedIn)
                {
                    if(curAccount.requestLoan(amount))
                    {
                        System.out.println("Loan request successful , sent for approval");
                    }
                    else
                    {
                        System.out.println("Failed to grant loan request");
                    }
                }
                else if(isEmployeeLoggedIn)
                {
                    System.out.println("You are in employee account , login from customer account");
                }
            }
            if(command.equals("Query"))
            {
                if(!isEmployeeLoggedIn)
                {
                    System.out.println("Current balance "+curAccount.getBalance()+"$");
                }
                else if(isEmployeeLoggedIn)
                {
                    System.out.println("You are in employee account , login from customer account");
                }
            }
            if(command.equals("Lookup"))
            {
                String name = commands.get(1);
                Account ac = (Account) b.getPeople(name);

                if(!isEmployeeLoggedIn)
                {
                    System.out.println("You don't have any permission for this operation");
                }
                else if(isEmployeeLoggedIn)
                {
                    System.out.println(name+"'s current account balance "+ac.getBalance()+"$");
                }
            }
            if(command.equals("Approve"))
            {
                if(!isEmployeeLoggedIn)
                {
                    System.out.println("You don't have any permission for this operation");
                    continue;
                }

                if(curEmployee.canApproveLoan())
                {
                    if(b.isLoanPending())
                    {
                        b.approveLoan();
                    }
                    else
                    {
                        System.out.println("No loans pending to approve");
                    }
                }
                else
                {
                    System.out.println("You don't have any permission for this operation");
                }
            }
            if(command.equals("Change"))
            {
                String ac_type = commands.get(1);
                String new_rate_s = commands.get(2);
                double new_rate = Double.parseDouble(new_rate_s);

                if(curEmployee.changeInterestRate(ac_type,new_rate))
                {
                    System.out.println("Interest rate for "+ac_type+" has been changed to "+new_rate);
                }
                else
                {
                    System.out.println("You don't have any permission for this operation");
                }
            }
            if(command.equals("See"))
            {
                if(curEmployee.canSeeInternalFund())
                {
                    System.out.println("Bank Internal Fund "+b.getFund());
                }
                else
                {
                    System.out.println("You don't have any permission for this operation");
                }
            }
            if(command.equals("Close"))
            {
                if(!isEmployeeLoggedIn)
                {
                    System.out.println("Transaction Closed for "+curAccount.getName());
                }
                else
                {
                    System.out.println("Operations for "+curEmployee.getName()+" closed");
                }


                curAccount = null;
                curEmployee = null;

                isEmployeeLoggedIn = false;
            }

//            Employee p1 = (Employee) b.getPeople("MD");
//            Object p2 = b.getPeople("Alice");
//
//            System.out.println(p1);
//            System.out.println(p2);

//            break;
        }
    }
}
