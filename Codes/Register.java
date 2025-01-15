public class Register implements lockable {
    private double pounds;
    private final double PRICE_POUNDS = 1.0;
    private int pieces;
    private final double PRICE_PIECES = 0.05;
    private String name;

    private boolean lockedObj = false;
    private int password;

    // constructor to create a new register (one for pounds, one for pieces)
    public Register(String n, int p, double lbs) {
        name = n;
        pieces = p;
        pounds = lbs;
        password = 1234;
    }

    // getters and setters for amount of pieces
    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    // getters and setters for amount of pounds
    public double getPounds() {
        return pounds;
    }

    public void setPounds(double pounds) {
        this.pounds = pounds;
    }

    // to calculate the price (in pieces/pounds)
    public double getPrice() {
        return (PRICE_PIECES * pieces) + (PRICE_POUNDS * pounds);
    }

    // Fixed toString() method that accepts total sales data as parameters
    public String toString(double totalSales, double totalSalesPounds, double totalSalesPieces, int totalPieces, double totalPounds) {
        String result = " ";
        result += "End of Day Report:\n";
        result += "Total Sales: $" + String.format("%.2f", totalSales) + "\n";
        result += "Total Sales (Pounds): $" + String.format("%.2f", totalSalesPounds) + "\n";
        result += "Total Sales (Pieces): $" + String.format("%.2f", totalSalesPieces) + "\n";
        result += "Total pieces sold: " + totalPieces + "\n";
        result += "Total pounds sold: " + totalPounds + "\n";
        return result;
    }

    /**
     * lockable interface methods
     */
   
    public void lock(int locker) { // this method locks the register
        if (password == locker) {
            lockedObj = true;
            System.out.println("The register is now locked.");
        } else {
            System.out.println("Incorrect password. Unable to lock.");
        }
    }

    public void unlock(int unlocker) { // this method unlocks the register
        if (password == unlocker) {
            lockedObj = false;
            System.out.println("The register is now unlocked.");
        } else {
            System.out.println("Incorrect password. Unable to unlock.");
        }
    }

    public boolean locked() {
        return lockedObj;
    }

    public void setkey(int pass) { // sets password
        this.password = pass;
    }
}