package BT17;

public class MaxSum {
    public static int solution(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num >= 0) {
                sum += num;
                maxSum = Math.max(sum, maxSum);
            } else {
                maxSum = Math.max(maxSum, num);
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 7, -2, -7, 4, 3, 2 })); // 9
        System.out.println(solution(new int[] { -7, -2, -7, -4, -3, -2 })); // -2
        System.out.println(solution(new int[] { 0, -1, 0, 0 })); // 0
    }
}
