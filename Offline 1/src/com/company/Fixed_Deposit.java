package com.company;

class Fixed_Deposit extends Account
{
    final double MIN_INIT_DEPOSIT = 100000;
    final double MIN_DEPOSIT = 50000;
    final double MAX_LOAN = 100000;

    private static double DEPOSIT_INTEREST_RATE = 15.0;
    private static double SERVICE_CHARGE = 500.0;

    Fixed_Deposit() { setAc_type("Fixed_Deposit"); }

    public static double getDepositInterestRate() { return DEPOSIT_INTEREST_RATE; }
    static void changeDepositInterestRate(double new_rate) { DEPOSIT_INTEREST_RATE = new_rate; }

    public static double getServiceCharge() { return SERVICE_CHARGE; }

    public boolean createAccount(double balance,String name)
    {
        if(balance >= MIN_INIT_DEPOSIT) {
            setBalance(balance);
            setName(name);
            return true;
        }
        return false;
    }

    public boolean deposit(double amount)
    {
        if(amount >= MIN_DEPOSIT) {
            addBalance(amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount)
    {
        if(amount > getBalance()) return false;

        if(getAc_age()>=1) {
            removeBalance(amount);
            return true;
        }

        return false;
    }

    public boolean requestLoan(double amount)
    {
        if(getLoan()+getPendingLoan()+amount <= MAX_LOAN) {
            setPendingLoan(getPendingLoan()+amount);
            return true; // loan request valid
        }
        return false;
    }
}
