package BT13;

public class SameDigitMerge {
    // Time complexity: O(n)
    public static int sameDigitMerge(int[] numbers) {
        int[] firstDigitCount = new int[10];
        int[] lastDigitCount = new int[10];
        for (int num : numbers) {
            String strNum = Integer.toString(num);
            int firstDigit = strNum.charAt(0) - '0';
            int lastDigit = strNum.charAt(strNum.length() - 1) - '0';
            firstDigitCount[firstDigit]++;
            lastDigitCount[lastDigit]++;
        }
        long result = 0;
        for (int i = 1; i < 10; i++) {
            result += firstDigitCount[i] * lastDigitCount[i];
        }
        return (int)(result % 1000000000);
    }

    public static void main(String[] args) {
        int[] nums1 = {30,12,29,91};  // 3
        int[] nums2 = {122,21,21,23}; // 5
        int[] nums3 = {12, 52, 32, 42}; // 0
        int[] nums4 = {12, 12, 12, 21}; // 6: [12,21] * 3 + [21,12] * 3
        int[] nums5 = {12, 23, 34, 41}; // 4
        System.out.println(sameDigitMerge(nums1));
        System.out.println(sameDigitMerge(nums2));
        System.out.println(sameDigitMerge(nums3));
        System.out.println(sameDigitMerge(nums4));
        System.out.println(sameDigitMerge(nums5));
        System.out.println(Math.sqrt(2));
    }
}
