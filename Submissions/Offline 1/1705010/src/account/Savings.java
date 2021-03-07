package account;

public class Savings extends Account
{
    private static double MIN_BALANCE = 1000;
    private static double MAX_LOAN = 10000;
    private static double DEPOSIT_INTEREST_RATE = 10.0; // changeable
    private static double SERVICE_CHARGE = 500.0;

    public Savings() { setAc_type("Savings"); }

    public static double getDepositInterestRate() { return DEPOSIT_INTEREST_RATE; }
    public static void changeDepositInterestRate(double new_rate){ DEPOSIT_INTEREST_RATE = new_rate;}

    public static double getServiceCharge() { return SERVICE_CHARGE; }

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

        if(getBalance()-amount >= MIN_BALANCE) {
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
