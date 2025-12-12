package BT16;

public class SortedSwap {
    public static boolean solution(int[] A) {
        // Time complexity: O(n)
        // First check: check for 2 numbers
        int largerNumIndex = -1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                largerNumIndex = i;
                break;
            }
        }
        // True if all sorted
        if (largerNumIndex == -1) {
            return true;
        }
        int smallNumIndex = -1;
        for (int j = largerNumIndex + 1; j < A.length - 1; j++) {
            if (A[j] > A[j + 1]) {
                smallNumIndex = j + 1;
                break;
            }
        }
        // If no smallNum, smallNum is the number next to largeNum
        if (smallNumIndex == -1) {
            smallNumIndex = largerNumIndex + 1;
            while (smallNumIndex < A.length - 1) {
                if (A[smallNumIndex] != A[smallNumIndex + 1]) {
                    break;
                }
                smallNumIndex++;
            }
        }
        // Swap
        int smallNumber = A[smallNumIndex];
        A[smallNumIndex] = A[largerNumIndex];
        A[largerNumIndex] = smallNumber;
        for (int k = Math.max(0, largerNumIndex - 1); k < A.length - 1; k++) {
            if (A[k] > A[k + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 1, 5, 3, 3, 7 })); // true
        System.out.println(solution(new int[] { 1, 3, 5, 3, 4 })); // false
        System.out.println(solution(new int[] { 1, 3, 5 })); // true

        System.out.println(solution(new int[] { 1, 2, 3, 8, 5, 6, 7, 4, 9, 2 }));
        System.out.println(solution(new int[] { 5, 4, 6 }));
        System.out.println(solution(new int[] { 3, 3, 1, 2, 4, 4 }));
        // {1, 5, 3, }
    }
}
