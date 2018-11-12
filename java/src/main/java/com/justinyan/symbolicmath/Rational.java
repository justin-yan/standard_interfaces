package com.justinyan.symbolicmath;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Rational implements Comparable<Rational> {

    private BigInteger numerator;
    private BigInteger denominator;

    Rational(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
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

    public Rational add(Rational addendum) {
        return null;
    };

    public Rational subtract(Rational subtrandum) {
        return null;
    };

    public Rational multiply(Rational multiplendum) {
        return null;
    };

    public Rational divide(Rational divisor) {
        return null;
    };


    public BigDecimal render(int digitsOfPrecision) {
        return null;
    };

    public static Rational fromString(String) {
        return null;
    };

    public static Rational fromInt(Integer sourceInt) {
        return new Rational(BigInteger.valueOf(sourceInt), BigInteger.valueOf(1));
    };

    public static Rational fromLong(Long) {
        return null;
    };

    public static Rational fromFloat(Float) {
        return null;
    };

    public static Rational fromDouble(Double) {
        return null;
    };


    public String serialize() {
        return null;
    };

    public static Rational deserialize(String) {
        return null;
    };

}
