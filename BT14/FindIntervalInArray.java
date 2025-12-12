package BT14;

import java.util.Arrays;

public class FindIntervalInArray {
    public static int findIntervalInArray(int[] A, int L, int R) {
        // Time complexity: O(n*k) where k = R - L + 1
        int LRLength = R - L + 1;
        int[] lastSeen = new int[LRLength];
        Arrays.fill(lastSeen, -1);
        int uniqueCount = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            if (value >= L && value <= R) {
                int index = value - L;
                if (lastSeen[index] == -1) {
                    uniqueCount++;
                }
                lastSeen[index] = i;
                if (uniqueCount == LRLength) {
                    int minIndex = lastSeen[0];
                    for (int j = 1; j < LRLength; j++) { // khi windows = size thi dung, khong can di den cuoi
                        minIndex = Math.min(minIndex, lastSeen[j]);
                    }
                    result = Math.min(result, i - minIndex + 1);
                }
            }
        }
        if (uniqueCount == LRLength) {
            return result;
        }
        return -1;
    } // code lai bai nay bang sliding window
      // create, get index, delete an element, add an element

    public static void main(String[] args) {
        System.out.println(findIntervalInArray(new int[] { 2, 1, 4, 3, 2, 1, 1, 4 }, 2, 4)); // 3
        System.out.println(findIntervalInArray(new int[] { 109, 1, 1, 1, 1, 1, 109 - 1 }, 109 - 1, 109)); // 7
        System.out.println(findIntervalInArray(new int[] { 1, 3, 5, 7 }, 3, 5)); // -1
    }
}
