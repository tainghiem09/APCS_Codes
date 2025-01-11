//********************************************************************
// Address.java      
// Tai Nghiem
// 12/12/24
//********************************************************************

public class Address implements Comparable {
    private String streetAddress, city;
    private static String state = "IL";
    private int zipCode;

    /*
     * constructor for the Address object
     * @param String streetAddress, String city, String state, int zipCode
     */
    public Address(String streetAddress, String city, String state, int zipCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    /*
     * The comparable interface is used to compare the street names/numbers.
     * @param Object obj
     */
    public int compareTo(Object obj) {
        Address other = (Address) obj;

        String thisStreetName = this.streetAddress.substring(this.streetAddress.indexOf(" ") + 1);
        String otherStreetName = other.streetAddress.substring(other.streetAddress.indexOf(" ") + 1);

        // Compare the street names, first
        int nameComparison = thisStreetName.compareTo(otherStreetName);
        if (nameComparison != 0) {
            return nameComparison;
        }

        // If the street names are the same, move on to compare the numbers
        int thisHouseNumber = Integer.parseInt(this.streetAddress.substring(0, this.streetAddress.indexOf(" ")));
        int otherHouseNumber = Integer.parseInt(other.streetAddress.substring(0, other.streetAddress.indexOf(" ")));

        return Integer.compare(thisHouseNumber, otherHouseNumber);
    }

    /*
     * Static method to set state with password.
     * @param String password, String st
     */
    public static void setState(String password, String setstate) {
        if (password.equals("APCS")) {
            state = setstate;
        } else {
            state = "IL";
            System.out.println("Incorrect password, please try again.");
        }
    }

    /*
     * This sets an address given an object.
     * @param Address obj
     */
    public void setAddress(Address obj) {
        this.streetAddress = obj.streetAddress;
        this.city = obj.city;
        this.zipCode = obj.zipCode;
    }

    /*
     * This sets an Address given street, city, and zip code.
     * @param String street, String city, int zip
     */
    public void setAddress(String street, String city, int zip) {
        this.streetAddress = street;
        this.city = city;
        this.zipCode = zip;
    }

    /*
     * toString method to print out the address
     * @return result
     */
    public String toString() {
        String result;
        result = streetAddress + "\n";
        result += city + ", " + state + "  " + zipCode;
        return result;
    }
}
