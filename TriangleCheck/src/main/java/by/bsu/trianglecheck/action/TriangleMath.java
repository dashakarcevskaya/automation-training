package by.bsu.trianglecheck.action;

import by.bsu.trianglecheck.exception.TriangleMathException;

public class TriangleMath {
    public boolean isTriangle(double a, double b, double c) {
        if (a == 0 || b == 0 || c == 0) {
            throw new TriangleMathException("Zero side");
        }
        if (a < 0 || b < 0 || c < 0) {
            throw new TriangleMathException("Negative length side");
        }
        if (Double.compare(a, Double.NaN) * Double.compare(b, Double.NaN) * Double.compare(c, Double.NaN) == 0) {
            throw new TriangleMathException("Not a number");
        }
        return check(a, b, c) && check(a, c, b) && check(b, c, a);
    }

    private boolean check(double a, double b, double c){
        return (a + b) > c;
    }
}
