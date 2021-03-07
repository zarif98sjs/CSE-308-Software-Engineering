package com.company;

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