
package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {


        Bank b = new Bank();

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

                if(!b.pkEnsured(name))
                {
                    System.out.println("A user with this name already exists");
                    continue;
                }

                Account ac = null;

                if(ac_type.equals("Student"))  ac = new Student();
                else if(ac_type.equals("Savings"))  ac = new Savings();
                else if(ac_type.equals("Fixed_Deposit"))  ac = new Fixed_Deposit();

                if(ac.createAccount(init_balance,name))
                {
                    b.accounts.add(ac);
                    System.out.println(ac_type+" account for "+name+" Created; initial balance "+init_balance+"$");

                    curAccount = ac;
                    isEmployeeLoggedIn = false;
                }
                else{
                    System.out.println("Can not create account");
                }
            }
            if(command.equals("Open"))
            {
                String name = commands.get(1);

                if(b.isEmployee(name))
                {
                    curEmployee = (Employee)b.getPeople(name);
                    isEmployeeLoggedIn = true;

                    System.out.print(name + " Active,");

                    if(b.isLoanPending()) System.out.println("There are loans pending");
                    else System.out.println("There are no loans pending");
                }
                else
                {
                    curAccount = (Account)b.getPeople(name);
                    isEmployeeLoggedIn = false;

                    System.out.println("Welcome back," + curAccount.getName());
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
                    if(curAccount.withdraw(amount)) {
                        System.out.println(amount+"$ Withdrawn ; current balance "+curAccount.getBalance()+"$");
                    }
                    else {
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
                    if(curAccount.requestLoan(amount)) {
                        System.out.println("Loan request successful , sent for approval");
                    }
                    else {
                        System.out.println("Failed to grant loan request");
                    }
                }
                else if(isEmployeeLoggedIn) {
                    System.out.println("You are in employee account , login from customer account");
                }
            }
            if(command.equals("Query"))
            {
                if(!isEmployeeLoggedIn) {
                    System.out.println("Current balance "+curAccount.getBalance()+"$ , Loan "+curAccount.getLoan());
                }
                else if(isEmployeeLoggedIn) {
                    System.out.println("You are in employee account , login from customer account");
                }
            }
            if(command.equals("Lookup"))
            {
                String name = commands.get(1);
                Account ac = (Account) b.getPeople(name);

                if(!isEmployeeLoggedIn) {
                    System.out.println("You don't have any permission for this operation");
                }
                else if(isEmployeeLoggedIn) {
                    System.out.println(name+"'s current account balance "+curEmployee.lookup(ac)+"$");
                }
            }
            if(command.equals("Approve"))
            {
                if(!isEmployeeLoggedIn) {
                    System.out.println("You don't have any permission for this operation");
                    continue;
                }

                if(curEmployee.canApproveLoan())
                {
                    if(b.isLoanPending()) {
                        b.approveLoan();
                    }
                    else {
                        System.out.println("No loans pending to approve");
                    }
                }
                else {
                    System.out.println("You don't have any permission for this operation");
                }
            }
            if(command.equals("Change"))
            {
                String ac_type = commands.get(1);
                String new_rate_s = commands.get(2);
                double new_rate = Double.parseDouble(new_rate_s);

                if(curEmployee.changeInterestRate(ac_type,new_rate)) {
                    System.out.println("Interest rate for "+ac_type+" has been changed to "+new_rate);
                }
                else {
                    System.out.println("You don't have any permission for this operation");
                }
            }
            if(command.equals("See"))
            {
                if(curEmployee.canSeeInternalFund()) {
                    System.out.println("Bank Internal Fund "+b.getFund());
                }
                else {
                    System.out.println("You don't have any permission for this operation");
                }
            }
            if(command.equals("INC"))
            {
                System.out.println("One Year Passed By");
                b.increaseYear();
            }
            if(command.equals("Close"))
            {
                if(!isEmployeeLoggedIn) {
                    System.out.println("Transaction Closed for "+curAccount.getName());
                }
                else {
                    System.out.println("Operations for "+curEmployee.getName()+" closed");
                }

                curAccount = null;
                curEmployee = null;

                isEmployeeLoggedIn = false;
            }

        }
    }
}
