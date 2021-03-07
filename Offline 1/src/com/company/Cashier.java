package com.company;

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
