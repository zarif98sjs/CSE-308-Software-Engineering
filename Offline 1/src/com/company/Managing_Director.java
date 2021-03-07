package com.company;

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
        if(ac_type.equals("Savings")) {
            Savings.changeDepositInterestRate(new_rate);
        }
        else if(ac_type.equals("Student")) {
            Student.changeDepositInterestRate(new_rate);
        }
        else if(ac_type.equals("Fixed_Deposit")) {
            Fixed_Deposit.changeDepositInterestRate(new_rate);
        }
        return true;
    }

    public boolean canSeeInternalFund() { return true; }
}