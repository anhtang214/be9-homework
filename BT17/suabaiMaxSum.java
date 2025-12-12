package BT17;

public class suabaiMaxSum {
    public int maxContinuousSum(int[] A) {
        int maxSum = A[0];
        int currentSum = A[0];

        for (int i = 1; i < A.length; i++) {
            currentSum = Math.max(A[i], currentSum + A[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
