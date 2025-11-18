package BT13;

public class ValueOccurrences {
    public static int valueOccurrences(int[] nums) {
        int prevNum = nums[0], index = 1, count = 1, result = 0;
        while (index < nums.length) {
            if (nums[index] == prevNum) {
                count++;
            } else {
                result += Math.min(count, Math.abs(count - prevNum));
                count = 1;
                prevNum = nums[index];
            }
            index++;
        }
        result += Math.min(count, Math.abs(count - prevNum));
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
    }
}
