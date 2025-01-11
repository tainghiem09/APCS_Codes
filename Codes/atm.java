public interface atm
{
//adds amount to the balance
public double deposit(double amount);
//subtracts amount & fee from balance
public double withdraw (double amount, double fee);
//subtracts amount from obj and add to this account
public void transfer (Account obj, double amount);
}

