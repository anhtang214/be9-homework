package suabaiBT13;

public class NoEqualDigits {
    public static int noEqualDigits(int N) {
        N++;
        int[] digits = new int[String.valueOf(N).length() + 1];
        int result = 0;

        for (int i = 0, j = N; i < digits.length; i++) {
            digits[i] = j % 10;
            j = (int) j / 10;
        }
        // given N = 044433
        // digits = [3,3,4,4,4,0]
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] == digits[i + 1]) {
                if (digits[i] == 9) {
                    digits[i++] = 1;
                    while (digits[i] == 9) {
                        digits[i] = digits[i - 1] == 0 ? 1 : 0;
                        i++;
                    }
                }
                digits[i--]++;
            }
        }
        // digits = [4,3,5,5,4,0]
        // compute: 4 * 10^4 + 5 * 10^3 + 5 * 10^2 + ...
        for (int i = digits.length - 1; i >= 0; i--) {
            if (result > N)
                digits[i] = digits[i + 1] == 0 ? 1 : 0;
            result += digits[i] * Math.pow(10, i);
        }
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
