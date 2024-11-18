package fractions;

public class Fraction {
    private double numerator;
    private double denominator;

    public Fraction(double numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction(double numerator, double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public double getNumerator() {
        return numerator;
    }

    public double getDenominator() {
        return denominator;
    }

    public Fraction addFraction(Fraction fraction) {
        if (getDenominator() == fraction.getDenominator()) {
            return new Fraction(getNumerator() + fraction.getNumerator(), getDenominator());
        }
        else {
            double numerator = getNumerator() * fraction.getDenominator() + fraction.getNumerator() * getDenominator();
            double denominator = getDenominator() * fraction.getDenominator();
            return new Fraction(numerator, denominator);
        }
    }

    public Fraction subtractFraction(Fraction fraction) {
        if (getDenominator() == fraction.getDenominator()) {
            return new Fraction(getNumerator() - fraction.getNumerator(), getDenominator());
        }
        else {
            double numerator = getNumerator() * fraction.getDenominator() - fraction.getNumerator() * getDenominator();
            double denominator = getDenominator() * fraction.getDenominator();
            return new Fraction(numerator, denominator);
        }
    }

    public Fraction multiplyFraction(Fraction fraction) {
        return new Fraction(getNumerator() * fraction.getNumerator(), getDenominator() * fraction.getDenominator());
    }

    public Fraction divideFraction(Fraction fraction) {
        return new Fraction(getNumerator() * fraction.getDenominator(), getDenominator() * fraction.getNumerator());
    }

    public String printString() {
        return String.format("%f/%f", getNumerator(), getDenominator());
    }
}