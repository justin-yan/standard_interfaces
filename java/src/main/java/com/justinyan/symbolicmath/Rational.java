package com.justinyan.symbolicmath;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Rational implements Comparable<Rational> {

    private BigInteger numerator;
    private BigInteger denominator;

    Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        if (denominator.signum() == -1) {
            this.numerator = numerator.divide(gcd).negate();
            this.denominator = denominator.divide(gcd).negate();
        } else {
            this.numerator = numerator.divide(gcd);
            this.denominator = denominator.divide(gcd);
        }
    }

    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Rational)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Rational c = (Rational) o;

        // Compare the data members and return accordingly
        return numerator.equals(c.numerator) && denominator.equals(c.denominator);
    }

    @Override
    public int compareTo(Rational otherRational) {
        return 1; // TODO: implement proper compare functionality using LCM for denoms
    }

    public Rational add(Rational addend) {
        BigInteger denomGcd = denominator.gcd(addend.denominator);
        BigInteger factor1 = addend.denominator.divide(denomGcd);
        BigInteger factor2 = denominator.divide(denomGcd);

        // Find the LCM of the denominator, multiply numerators by sufficient amount, add them together.
        BigInteger newNumerator = numerator.multiply(factor1).add(addend.numerator.multiply(factor2));
        Rational sum = new Rational(newNumerator, factor1.multiply(factor2).multiply(denomGcd));
        return sum;
    }

    public Rational subtract(Rational subtrahend) {
        BigInteger denomGcd = denominator.gcd(subtrahend.denominator);
        BigInteger factor1 = subtrahend.denominator.divide(denomGcd);
        BigInteger factor2 = denominator.divide(denomGcd);

        // Find the LCM of the denominator, multiply numerators by sufficient amount, subtract them.
        BigInteger newNumerator = numerator.multiply(factor1).subtract(subtrahend.numerator.multiply(factor2));
        Rational difference = new Rational(newNumerator, factor1.multiply(factor2).multiply(denomGcd));
        return difference;
    }

    public Rational multiply(Rational factor) {
        // Multiply numerators and denominators.
        Rational product = new Rational(numerator.multiply(factor.numerator), denominator.multiply(factor.denominator));
        return product;
    }

    public Rational divide(Rational divisor) {
        // Multiply numerator1xdenominator2 and vice versa.
        Rational quotient = new Rational(numerator.multiply(divisor.denominator), denominator.multiply(divisor.denominator));
        return quotient;
    }


    public BigDecimal render(int digitsOfPrecision, RoundingMode roundingMode) {
        return new BigDecimal(numerator).divide(new BigDecimal(denominator), digitsOfPrecision, roundingMode);
    }

    public static Rational fromString(String sourceString) {
        return null;
    }

    public static Rational fromInt(Integer sourceInt) {
        return new Rational(BigInteger.valueOf(sourceInt), BigInteger.valueOf(1));
    }

    public static Rational fromLong(Long sourceLong) {
        return null;
    }

    public static Rational fromFloat(Float sourceFloat) {
        return null;
    }

    public static Rational fromDouble(Double sourceDouble) {
        return null;
    }


    public String serialize() {
        return "1:".concat(numerator.toString()).concat("/").concat(denominator.toString());
    }

    public static Rational deserialize(String sourceString) {
        Rational deser;
        String[] split = sourceString.split(":", 2);
        switch (split[0]) {
            case "1":
                String[] rawRat = split[1].split("/", 2);
                deser = new Rational(new BigInteger(rawRat[0]), new BigInteger(rawRat[1]));
                break;
            default:
                throw new NotImplementedException();
        }
        return deser;
    }

}
