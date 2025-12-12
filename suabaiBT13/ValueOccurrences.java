package suabaiBT13;

public class ValueOccurrences {
    public static int valueOccurrences(int[] nums) {
        // Time complexity: O(n)
        int index = 1, count = 1, result = 0;
        while (index < nums.length) {
            int value = nums[index];
            while (value == nums[index] && index < nums.length) {
                count++;
                index++;
            }
            result += Math.min(count, Math.abs(count - value));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,3,4,4,4};        // 3
        int[] nums2 = {1,2,2,2,5,5,5,8};    // 4
        int[] nums3 = {1,1,1,1,3,3,4,4,4,4,4}; // 5
        int[] nums4 = {10,10,10};           // 3
        System.out.println(valueOccurrences(nums1));
        System.out.println(valueOccurrences(nums2));
        System.out.println(valueOccurrences(nums3));
        System.out.println(valueOccurrences(nums4));
        System.out.println(Math.sqrt(2));
    }
}
