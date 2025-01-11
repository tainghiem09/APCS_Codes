/**
 * Author: Tai Nghiem
 * Date: 12/3/24
 */

import java.util.Scanner;

public class Banking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Account acct1 = new Account("Ted Murphy", 72354, 102.56);
        Account acct2 = new Account("Anita Gomez", 69713, 40.00);
        Account acct3 = new Account("Sanchit Reddy", 93757, 759.32);
        Account acct4 = new Account("Tai Nghiem", 99999);

        System.out.println("Bank Menu");
        System.out.println("1) Deposit");
        System.out.println("2) Withdrawal");
        System.out.println("3) Transfer");
        System.out.println("4) Exit Menu");

        int choice = scan.nextInt();

        // Performs action based on choice
        if (choice == 1) {
            acct4.deposit(100);
            System.out.println("Depositing $100 into account 99999");
            System.out.println(acct4);
        } else if (choice == 2) {
            acct2.withdraw(30, 0);
            System.out.println("Withdrawing $30 from account 69713");
            System.out.println(acct2);
        } else if (choice == 3) {
            acct3.transfer(acct1);
            System.out.println("Transferring money from account 93757 to account 72354");
            System.out.println(acct3);
            System.out.println(acct1);
        } else {
            System.out.println("Thank you.");
        }

        acct1.addInterest();
        acct2.addInterest();
        acct3.addInterest();
        acct4.addInterest();
    }
}