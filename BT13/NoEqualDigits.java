package BT13;

public class NoEqualDigits {
    public static int noEqualDigits(int num) {
        // Time complexity: O(n) where n = length of digit
        // Worst case: O(n+1) where n = length of digit
        if (num < 10) {
            return num + 1;
        }
        boolean isValidResult = false;
        int result = num + 1;
        int loop = 0;
        while (!isValidResult) {
            String strResult = Integer.toString(result);
            isValidResult = true;
            for (int i = 0; i < strResult.length() - 1; i++) {
                loop++;
                int curDigit = strResult.charAt(i) - '0';
                int nextDigit = strResult.charAt(i + 1) - '0';
                if (curDigit == nextDigit) {
                    isValidResult = false;
                    int power = strResult.length() - (i + 2);
                    result = (int) ((int) (result / Math.pow(10, power) + 1) * Math.pow(10, power));
                    break;
                }
            }
        }
        System.out.println("Loop: " + loop);
        return result;
    }

    public static void main(String[] args) {
        int num1 = 55;
        int num2 = 1765;
        int num3 = 98;
        int num4 = 44432;
        int num5 = 3298;
        int num6 = 1992;
        int num7 = 98989898;
        // System.out.println(noEqualDigits(num1));
        // System.out.println(noEqualDigits(num2));
        // System.out.println(noEqualDigits(num3));
        // System.out.println(noEqualDigits(num4));
        // System.out.println(noEqualDigits(num5));
        // System.out.println(noEqualDigits(num6));
        System.out.println(noEqualDigits(num7));
    }

}
