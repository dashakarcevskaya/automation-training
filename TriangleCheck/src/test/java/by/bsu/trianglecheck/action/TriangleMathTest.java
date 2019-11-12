package by.bsu.trianglecheck.action;

import by.bsu.trianglecheck.exception.TriangleMathException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleMathTest {
    private TriangleMath triangleMath;

    @BeforeMethod
    public void init() {
        triangleMath = new TriangleMath();
    }

    @DataProvider
    Object[][] sidesAreZero() {
        return new Object[][] { { 0.0, 0.0, 0.0 },
                { 1.0, 0.0, 0.0 }, { 0.0, 1.0, 0.0 }, { 0.0, 0.0, 1.0 },
                { 1.0, 1.0, 0.0 }, { 1.0, 0.0, 1.0 }, { 0.0, 1.0, 1.0 } };
    }

    @DataProvider
    Object[][] sidesAreNegative() {
        return new Object[][] { {-9.0, -9.0, -9.0},
            {-9.0, 9.0, 9.0}, {9.0, -9.0, 9.0}, {9.0, 9.0, -9.0},
            {-9.0, -9.0, 9.0}, {-9.0, 9.0, -9.0}, {9.0, -9.0, -9.0} };
    }

    @DataProvider
    Object[][] sideEqualToSumOfOtherTwo() {
        return new Object[][] {
                {8.0, 3.0, 5.0}, {3.0, 8.0, 5.0}, {3.0, 5.0, 8.0} };
    }

    @DataProvider
    Object[][] notANumberSides() {
        return new Object[][] {
                {Double.NaN, Double.NaN, Double.NaN},
                {Double.NaN, 8.0, 8.0}, {8.0, Double.NaN, 8.0}, {8.0, 8.0, Double.NaN},
                {Double.NaN, Double.NaN, 8.0}, {Double.NaN, 8.0, Double.NaN}, {8.0, Double.NaN, Double.NaN} };
    }

    @Test(dataProvider = "sidesAreZero", expectedExceptions = { TriangleMathException.class })
    public void isLengthSidesZero(Double a, Double b, Double c) {
        triangleMath.isTriangle(a, b, c);
    }

    @Test(dataProvider = "sidesAreNegative", expectedExceptions = { TriangleMathException.class })
    public void isLengthSidesNegative(Double a, Double b, Double c) {
        triangleMath.isTriangle(a, b, c);
    }

    @Test(dataProvider = "sideEqualToSumOfOtherTwo")
    public void isSideSumOfOtherTwo(Double a, Double b, Double c) {
        assertFalse(triangleMath.isTriangle(a, b, c));
    }

    @Test(dataProvider = "notANumberSides", expectedExceptions = { TriangleMathException.class })
    public void isSideNAN(Double a, Double b, Double c) {
        triangleMath.isTriangle(a, b, c);
    }

    @Test
    public void sideShorterThanSumOfOtherTwo() {
        assertTrue(triangleMath.isTriangle(15.0, 14.0, 11.0));
    }

    @Test
    public void sideGreaterThanSumOfOtherTwo() {
        assertFalse(triangleMath.isTriangle(10.0, 2.0, 3.0));
    }

    @Test
    public void triangleEquilateral() {
        assertTrue(triangleMath.isTriangle(9.9, 9.9, 9.9));
    }

    @Test
    public void triangleIsoceles() {
        assertTrue(triangleMath.isTriangle(5.7, 5.7, 4.1));
    }

    @Test
    public void triangleRight() {
        assertTrue(triangleMath.isTriangle(12, 9, 15));
    }

    @Test
    public void sidesAreMinDouble() {
        assertTrue(triangleMath.isTriangle(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE));
    }
}