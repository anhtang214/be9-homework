package BT11;

import java.util.Arrays;

public class MinDistinct {
    public int findMissingNum(int startIndex, int[] count) {
        for (int i = startIndex; i < count.length; i++) {
            if (count[i] == 0) {
                return i;
            }
        }
        
    }

    public static int minDistinct2(int[] A) {
        int result = 0;
        int[] count = new int[A.length];
        while (true) {

        }
        for (int i = 0; i < A.length; i++) {
            int expectedValue = i + 1;
            result += Math.abs(A[i] - expectedValue);
        } 
        return result;
    }


    public static int minDistinct(int[] A) {
        int result = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            int expectedValue = i + 1;
            result += Math.abs(A[i] - expectedValue);
        } 
        return result;
    }

    public static void main(String[] args) {
        int[] A1 = {1,2,1};
        int[] A2 = {2,1,4,4};
        int[] A3 = {6,2,3,5,6,3};
        System.out.println(minDistinct(A1));
        System.out.println(minDistinct(A2));
        System.out.println(minDistinct(A3));
    }
}
