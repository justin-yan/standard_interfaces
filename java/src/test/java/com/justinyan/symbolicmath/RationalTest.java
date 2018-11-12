package com.justinyan.symbolicmath;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RationalTest {

    @Test
    public void sanityTest() {
        assertEquals(Rational.fromInt(1), Rational.fromInt(1));
    }

    @Test
    public void serializationV1Test() {
        List<Rational> testList = Arrays.asList(
                Rational.fromInt(1002),
                Rational.fromInt(1024),
                Rational.fromInt(1123),
                Rational.fromInt(144)
        );
        for (Rational rat : testList) {
            assertEquals(rat, Rational.deserialize(rat.serialize()));
        }
    }


}
