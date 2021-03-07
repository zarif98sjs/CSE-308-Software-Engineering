package account;

public class Student extends Account
{
    private static double WITHDRAWAL_LIMIT = 10000;
    private static double MAX_LOAN = 1000;
    private static double DEPOSIT_INTEREST_RATE = 5.0; // changeable
    private static double SERVICE_CHARGE = 0.0;

    public Student() { setAc_type("Student"); }

    public static double getDepositInterestRate() { return DEPOSIT_INTEREST_RATE; }
    public static void changeDepositInterestRate(double new_rate){ DEPOSIT_INTEREST_RATE = new_rate;}

    public static double getServiceCharge() { return SERVICE_CHARGE; }

    public boolean createAccount(double balance, String name)
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

        if(amount <= WITHDRAWAL_LIMIT) {
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