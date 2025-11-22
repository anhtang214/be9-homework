package BT13;

public class SquareRoot {
    public static double getSqrt(int num) {
        // Time complexity: O(log n)
        double low = 0;
        double high = num;
        double mid;
        double prevMid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            double square = mid * mid;
            if (num == square || prevMid == mid) {
                return mid;
            } else if (square < num) {
                low = mid;
            } else {
                high = mid;
            }
            prevMid = mid;
        }
        return (low + high) / 2;
    }

    public static void main(String[] args) {
        System.out.println(getSqrt(1));
        System.out.println(getSqrt(2));  // 1.4142135623730951
        System.out.println(getSqrt(4));
        System.out.println(getSqrt(3)); // 1.732050807568877
        System.out.println(getSqrt(16));
    }
}