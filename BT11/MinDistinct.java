package BT11;

import java.util.Arrays;

public class MinDistinct {
    public MinDistinct() {
    }

    public static int minDistinct(int[] var0) {
        int var1 = 0;
        Arrays.sort(var0);
        System.out.println(Arrays.toString(var0));

        for(int var2 = 0; var2 < var0.length; ++var2) {
            int var3 = var2 + 1;
            var1 += Math.abs(var0[var2] - var3);
        }

        return var1;
    }

    public static void main(String[] var0) {
        int[] var1 = new int[]{1, 2, 1};
        int[] var2 = new int[]{2, 1, 4, 4};
        int[] var3 = new int[]{6, 2, 3, 5, 6, 3};
        System.out.println(minDistinct(var1));
        System.out.println(minDistinct(var2));
        System.out.println(minDistinct(var3));
    }
}
