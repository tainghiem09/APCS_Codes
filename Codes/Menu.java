import java.util.Scanner;
import java.text.DecimalFormat;

public class Menu {
    public static double totalSales;
    public static double totalSalesPounds;
    public static double totalSalesPieces;
    public static int totalPieces;
    public static double totalPounds;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");

        // Creates two registers (one for pounds, one for pieces)
        Register registerPounds = new Register("Pounds", 0, 0.0);
        Register registerPieces = new Register("Pieces", 0, 0.0);

        boolean exit = false;

        // Switch based on user input
        while (!exit) {
            System.out.println("\nRegister System Menu:");
            System.out.println("1. Pounds Register");
            System.out.println("2. Pieces Register");
            System.out.println("3. Lock/Unlock Registers");
            System.out.println("4. End of Day Report");
            System.out.println("5. Exit");
            System.out.print("\nChoose an option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1: // Pounds register
                    if (registerPounds.locked()) {
                        System.out.println("\nEnter password to unlock:");
                        int password = scanner.nextInt();
                        if (password != 1234) {
                            System.out.println("Incorrect password. Access denied.\n");
                            break; // Exit the case
                        } else {
                            registerPounds.unlock(1234);
                        }
                    }

                    System.out.print("\nEnter number of pounds: ");
                    double pounds = scanner.nextDouble();
                    registerPounds.setPounds(registerPounds.getPounds() + pounds);
                    double pricePounds = registerPounds.getPrice();
                    totalSalesPounds += pricePounds;
                    totalPounds += pounds;

                    System.out.println("\nTotal owed: $" + df.format(pricePounds));
                    System.out.print("Enter payment: $");
                    double money = scanner.nextDouble();
                    double change = money - pricePounds;
                    if (change < 0) {
                        System.out.println("Not enough money. Try again.\n");
                    } else {
                        System.out.println("Change: $" + df.format(change) + "\n");
                        totalSales += pricePounds;
                    }
                    break;

                case 2: // Pieces register
                    if (registerPieces.locked()) {
                        System.out.println("\nEnter password to unlock:");
                        int password = scanner.nextInt();
                        if (password != 1234) {
                            System.out.println("Incorrect password. Access denied.\n");
                            break; // Exit the case
                        } else {
                            registerPieces.unlock(1234);
                        }
                    }

                    System.out.print("\nEnter number of pieces: ");
                    int pieces = scanner.nextInt();
                    registerPieces.setPieces(registerPieces.getPieces() + pieces);
                    double pricePieces = registerPieces.getPrice();
                    totalSalesPieces += pricePieces;
                    totalPieces += pieces;

                    System.out.println("\nTotal owed: $" + df.format(pricePieces));
                    System.out.print("Enter payment: $");
                    money = scanner.nextDouble();
                    change = money - pricePieces;
                    if (change < 0) {
                        System.out.println("Not enough money. Try again.\n");
                    } else {
                        System.out.println("Change: $" + df.format(change) + "\n");
                        totalSales += pricePieces;
                    }
                    break;

                case 3: // Lock/Unlock registers
                    System.out.println("\n1. Pounds Register");
                    System.out.println("2. Pieces Register");
                    System.out.print("Choose register to lock/unlock: ");
                    int registerChoice = scanner.nextInt();
                    System.out.print("Enter password: ");
                    int password = scanner.nextInt();

                    if (registerChoice == 1) {
                        if (registerPounds.locked()) {
                            registerPounds.unlock(password);
                        } else {
                            registerPounds.lock(password);
                        }
                    } else if (registerChoice == 2) {
                        if (registerPieces.locked()) {
                            registerPieces.unlock(password);
                        } else {
                            registerPieces.lock(password);
                        }
                    }
                    break;

                case 4: // End of Day Report
                    System.out.println(registerPounds.toString(totalSales, totalSalesPounds, totalSalesPieces, totalPieces, totalPounds));
                    break;

                case 5: // Exit
                    exit = true;
                    System.out.println("\nGoodbye!");
                    break;
            }
        }
    }
}