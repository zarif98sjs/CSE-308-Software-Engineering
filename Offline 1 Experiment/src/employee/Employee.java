package employee;

import account.Account;

abstract public class Employee
{
    private String em_type;
    private String name;

    public String getEm_type() { return em_type; }
    public void setEm_type(String em_type) { this.em_type = em_type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

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