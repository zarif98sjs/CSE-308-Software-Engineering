package com.company;

import java.util.ArrayList;

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

    public boolean pkEnsured(String name)
    {
        for(Account ac:accounts)
        {
            if(ac.getName().equals(name))
                return false;
        }
        return true;
    }

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

    public void increaseYear()
    {
        for(Account ac:accounts)
        {
            ac.setAc_age(ac.getAc_age()+1);

            double cur_loan = ac.getLoan() , cur_balance = ac.getBalance() , service_charge = 0.0;
            double deposit_interest = 0.0;
            double loan_interest = cur_loan * ac.LOAN_INTEREST_RATE * 0.01;

            // handle account
            if(ac.getAc_type().equals("Savings")){ deposit_interest = cur_balance * Savings.getDepositInterestRate() * 0.01; service_charge = Savings.getServiceCharge(); }
            if(ac.getAc_type().equals("Student")){ deposit_interest = cur_balance * Student.getDepositInterestRate() * 0.01; service_charge = Student.getServiceCharge(); }
            if(ac.getAc_type().equals("Fixed_Deposit")){ deposit_interest = cur_balance * Fixed_Deposit.getDepositInterestRate() * 0.01; service_charge = Fixed_Deposit.getServiceCharge(); }

            ac.addBalance(deposit_interest);
            ac.removeBalance(loan_interest + service_charge);

            // handle bank
            fund -= deposit_interest;
            fund += loan_interest;
            fund += service_charge;
        }
    }
}