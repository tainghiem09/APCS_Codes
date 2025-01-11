/**
 * Author: Tai Nghiem
 * Date: 12/3/24
 */
import java.text.NumberFormat;
import java.util.Scanner;

public class Account {
   private NumberFormat fmt = NumberFormat.getCurrencyInstance();
   private final double RATE = 0.035;  // Interest rate (3.5%)

   private int acctNumber;
   private double balance;
   private String name;
   private Scanner scan = new Scanner(System.in);

   /**
    * Constructor for an account with a balance.
    */
   public Account(String owner, int account, double initial) {
      name = owner;
      acctNumber = account;
      balance = initial;
   }

   /**
    * Creates a constructor for an account with zero balance
    */
   public Account(String owner, int accountNumber) {
      name = owner;
      acctNumber = accountNumber;
      balance = 0.0;
   }

   /**
    * Deposits money into an account.
    * @param amount
    * @return balance
    */
   public double deposit(double amount) {
      if (amount > 0) {
         balance += amount;
      } else {
         System.out.println("Error: Deposit amount is invalid.");
      }
      return balance;
   }

   /**
    * Withdraws money from the account.
    * @param amount, fee
    * @return balance
    */
   public double withdraw(double amount, double fee) {
      amount += fee;
      if (amount <= 0) {
         System.out.println("Error: Withdrawal amount is invalid.");
      } else if (amount > balance) {
         System.out.println("Error: Insufficient funds.");
      } else {
         balance -= amount;
      }
      return balance;
   }

   /**
    * Transfers money between accounts.
    * @param Account acc
    */
   public void transfer(Account acc) {
      System.out.print("Enter amount to transfer: ");
      double transfer = scan.nextDouble();
      if (transfer <= balance) {
         withdraw(transfer, 0);
         acc.deposit(transfer);
      } else {
         System.out.println("Error: Insufficient funds for transfer.");
      }
   }

   /**
    * Adds interest to accounts.
    * @return balance
    */
   public double addInterest() {
      balance += (balance * RATE);
      return balance;
   }

   // Convert account information with a toString method
   public String toString() {
      return String.format("Name: " + name + "\nAccount Number: " + acctNumber + "\nNew Account Balance: " + fmt.format(balance));
   }
   
   // Getters
   public String getName() {
      return name;
   }

   public double getBalance() {
      return balance;
   }

   public int getAcctNumber() {
      return acctNumber;
   }

}