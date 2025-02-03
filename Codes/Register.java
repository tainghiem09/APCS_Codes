import java.text.DecimalFormat;

public class Register {
    private String type;  // Can be "Pounds" or "Pieces"
    private int count;  // Store number of items (either pounds or pieces)
    private double price;  // Price for the specific type
    private boolean locked;  // Register's locked state

    // Static variables to track total sales across all instances
    private static double totalSalesPounds = 0.0;
    private static double totalSalesPieces = 0.0;
    private static int totalPounds = 0;
    private static int totalPieces = 0;

    // Create a DecimalFormat instance to format the total amount
    private static final DecimalFormat df = new DecimalFormat("#.00");

    // Constructor
    public Register(String type, double price) {
        this.type = type;
        this.price = price;
        this.count = 0;
        this.locked = false;  // Initially locked
    }

    // getters and setters
    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        updateSales();
    }

    /**
     * Lockable methods to implement lockable interface
     */
    public boolean isLocked() {
        return locked;
    }

    public void lock(int password) {
        this.locked = true;
    }

    public void unlock(int password) {
        this.locked = false;
    }

    // method to calculate price
    public double getPrice() {
        return count * price;
    }

    // Update total sales for pounds or pieces
    public void updateSales() {
        if (this.type.equals("Pounds")) {
            totalSalesPounds = totalSalesPounds + getPrice();
            totalPounds += count;
        } else if (this.type.equals("Pieces")) {
            totalSalesPieces = totalSalesPieces + getPrice();
            totalPieces += count;
        }
    }

    // Static methods to get the total sales data
    public static double getTotalSales() {
        return totalSalesPounds + totalSalesPieces;
    }

    public static double getTotalSalesPounds() {
        return totalSalesPounds;
    }

    public static double getTotalSalesPieces() {
        return totalSalesPieces;
    }

    public static int getTotalPounds() {
        return totalPounds;
    }

    public static int getTotalPieces() {
        return totalPieces;
    }

    // toString
    public String toString() {
        return type + " Register - Items: " + count + ", Total Amount: $" + df.format(getPrice());
    }
}
