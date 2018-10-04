
// Aaron Wu
// 9/24/18
// Program to add, subtract, multiply, and divide fractions, using methods and objects
// Objects are used to store fractions and methods are used for each operation

public class Fraction {
    // Make Variables
    private int numerator;
    private int denominator;

    // Constructs a Fraction object
    // Takes arguments and assigns them to numerator and denominator
    public Fraction(int num, int den) {
        numerator = num;
        denominator = den;
    }

    // Getter for Numerator
    public int getNumerator() {
        return numerator;
    }

    // Getter for Denominator
    public int getDenominator() {
        return denominator;
    }

    // Setter for Numerator
    public void setNumerator(int num) {
        numerator = num;
    }

    // Setter for Denominator
    public void setDenominator(int den) {
        denominator = den;
    }

    /*
     * Adds another fraction object given by the argument to the original fraction,
     * uses common denominator to add and outputs a new fraction object as the
     * result
     */
    public Fraction add(Fraction other) {
        int sumnum = (getNumerator() * other.getDenominator()) + (other.getNumerator() * getDenominator());
        int newden = other.getDenominator() * getDenominator();
        Fraction answer = new Fraction(sumnum, newden);
        return answer;
    }

    /*
     * Same as previous method, uses objects in the same way but uses common
     * denominator to subtract second Fraction object from first instead of adding
     */
    public Fraction subtract(Fraction other) {
        int sumdiff = (getNumerator() * other.getDenominator()) - (other.getNumerator() * getDenominator());
        int newden = other.getDenominator() * getDenominator();
        Fraction answer = new Fraction(sumdiff, newden);
        return answer;
    }

    /*
     * Same as previous but multiplies two Fraction objects together
     */
    public Fraction multiply(Fraction other) {
        int prodnum = getNumerator() * other.getNumerator();
        int proddem = getDenominator() * other.getDenominator();
        Fraction answer = new Fraction(prodnum, proddem);
        return answer;
    }

    /*
     * Same as previous but divides first Fraction object by second Fraction object
     */
    public Fraction divide(Fraction other) {
        int prodnum = getNumerator() * other.getDenominator();
        int proddem = getDenominator() * other.getNumerator();
        Fraction answer = new Fraction(prodnum, proddem);
        return answer;
    }

    // Turns answer into a string for output
    public String toString() {
        return getNumerator() + "/" + getDenominator();
    }

    public static void main(String[] args) {

        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 5);

        Fraction sum = f1.add(f2);
        System.out.println(f1.toString() + " + " + f2.toString() + " = " + sum.toString());

        Fraction difference = f1.subtract(f2);
        System.out.println(f1.toString() + " - " + f2.toString() + " = " + difference.toString());

        Fraction product = f1.multiply(f2);
        System.out.println(f1.toString() + " * " + f2.toString() + " = " + product.toString());

        Fraction quotient = f1.divide(f2);
        System.out.println(f1.toString() + " / " + f2.toString() + " = " + quotient.toString());
    }
}