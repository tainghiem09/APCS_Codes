public class Rational {
    private int numerator, denominator;

    /**----------------------------------------------------------------
     *  Sets up the rational number
     *  @param numer, denom
     */
    public Rational(int numer, int denom) {
        if (denom == 0)
        denom = 1;

        // Make the numerator "store" the sign
        if (denom < 0) {
            numer = numer * -1;
            denom = denom * -1;
        }

        numerator = numer;
        denominator = denom;

        reduce();
    }

    /**----------------------------------------------------------------
     *  Returns the numerator of this rational number.
     */
    public int getNumerator() {
        return numerator;
    }

    /**----------------------------------------------------------------
     *  Returns the denominator of this rational number.
     */
    public int getDenominator() {
        return denominator;
    }

    /**----------------------------------------------------------------
     *  Returns the reciprocal of this rational number.
     */
    public Rational reciprocal() {
        return new Rational(denominator, numerator);
    }

    /**----------------------------------------------------------------
     *  Adds this rational number to other rational number passed as parameter.
     *  @param r2
     *  @return added result --> new Rational(newNum + newNum2, op 2)
     */
    public Rational add(Rational r2) {
        int op2 = denominator * r2.getDenominator();
        int newNum = numerator * (op2 / denominator);
        int newNum2 = r2.getNumerator() * (op2 / r2.getDenominator());
        return new Rational(newNum + newNum2, op2);
    }

    /**----------------------------------------------------------------
     *  Subtracts the rational number passed as a parameter from the first rational number.
     *  @param r2
     *  @return subtracted result --> new Rational(newNum - newNum2, op2)
     */
    public Rational subtract(Rational r2) {
        int op2 = denominator * r2.getDenominator();
        int newNum = numerator * (op2 / denominator);
        int newNum2 = r2.getNumerator() * (op2 / r2.getDenominator());
        return new Rational(newNum - newNum2, op2);
    }

    /**----------------------------------------------------------------
     *  Multiplies this rational number by the other.
     *  @param r2
     *  @return multiplied result --> new Rational(op3, op4)
     */
    public Rational multiply(Rational r2) {
        int op3 = numerator * r2.getNumerator();
        int op4 = denominator * r2.getDenominator();
        return new Rational(op3, op4);
    }

    /**----------------------------------------------------------------
     *  Divides this rational number by the one passed as a parameter.
     *  @param r2
     *  @return divided result --> multiply(r2.reciprocal())
     */
    public Rational divide(Rational r2) {
        return multiply(r2.reciprocal());
    }

    /**----------------------------------------------------------------
     *  Determines if this rational number is equal to the other, after reduction.
     *  @param r2
     *  @return true or false
     */
    public boolean equals(Rational r2) {
        return (numerator == r2.getNumerator() && denominator == r2.getDenominator());
    }

    /**----------------------------------------------------------------
     *  Returns this rational number as a string.
     *  @return toString
     */
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**----------------------------------------------------------------
     *  Reduces this rational number by dividing both the numerator
     *  and the denominator by their greatest common divisor.
     */
    private void reduce() {
        if (numerator != 0) {
            int common = gcd(Math.abs(numerator), denominator);
            numerator = numerator / common;
            denominator = denominator / common;
        }
    }

    /**----------------------------------------------------------------
     *  Computes and returns the greatest common divisor of the two
     *  positive parameters. Uses Euclid's algorithm.
     *  @return num1
     */
    private int gcd(int num1, int num2) {
        while (num1 != num2)
            if (num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;

        return num1;
    }
}