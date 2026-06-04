package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SqrtTest {

    private static final double EPS = 1e-9;

    @Test
    public void CanCalculateAverageOfTwoNumbers() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(5.0, sqrt.average(2.0, 8.0), EPS);
    }

    @Test
    public void CanHandleNegativeNumbersInAverage() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(-1.0, sqrt.average(-3.0, 1.0), EPS);
    }

    @Test
    public void CheckGoodReturnsTrueWhenGuessIsCloseEnough() {
        Sqrt sqrt = new Sqrt(0.0);
        assertTrue(sqrt.good(2.000000001, 4.0));
    }

    @Test
    public void CheckGoodReturnsFalseWhenGuessIsFar() {
        Sqrt sqrt = new Sqrt(0.0);
        assertFalse(sqrt.good(2.5, 4.0));
    }

    @Test
    public void CanImproveGuessTowardsSquareRoot() {
        Sqrt sqrt = new Sqrt(0.0);
        double improved = sqrt.improve(1.0, 9.0);
        assertEquals(5.0, improved, EPS);
    }

    @Test
    public void CheckIterReturnsGuessImmediatelyIfGood() {
        Sqrt sqrt = new Sqrt(0.0);
        double result = sqrt.iter(3.0, 9.0);
        assertEquals(3.0, result, EPS);
    }

    @Test
    public void CanIterateUntilConvergence() {
        Sqrt sqrt = new Sqrt(0.0);
        double result = sqrt.iter(1.0, 2.0);
        assertEquals(Math.sqrt(2.0), result, 1e-8);
    }

    @Test
    public void CanComputeSquareRootOfTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        double result = sqrt.calc();
        assertEquals(Math.sqrt(2.0), result, 1e-8);
    }

    @Test
    public void CanComputeSquareRootOfPerfectSquare() {
        Sqrt sqrt = new Sqrt(25.0);
        assertEquals(5.0, sqrt.calc(), EPS);
    }

    @Test
    public void CanComputeSquareRootOfLargeNumber() {
        Sqrt sqrt = new Sqrt(1e12);
        assertEquals(1e6, sqrt.calc(), 1e-3);
    }
}
