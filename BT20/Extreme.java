package BT20;

public class Extreme {
    public static int solution(int[] nums) {
        // Time complexity: O(n)
        if (nums.length == 0) {
            return -1;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        float average = (float)sum / nums.length;
        float extreme = Math.abs(nums[0] - average);
        int extremeIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            float deviation = Math.abs(nums[i] - average);
            if (extreme < deviation) {
                extreme = deviation;
                extremeIndex = i;
            }
        }
        return extremeIndex;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{9,4,3,-10})); // 3
        System.out.println(solution(new int[]{-20,-8,-2,-3})); // 0
    }
}
