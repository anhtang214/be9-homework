package BT16;.

public class SameSumDice {
    public static int solution(int[] A, int[] B) {
        // Time complexity: O(n)
        int sumA = 0;
        int sumB = 0;
        for (int a : A) {
            sumA += a;
        }
        for (int b : B) {
            sumB += b;
        }
        if (sumA == sumB) {
            return 0;
        }
        if (sumA < sumB) { // Ensure A > B
            int[] temp = B;
            B = A;
            A = temp;
        }
        int steps = 0;
        int[] changeCount = new int[6];
        int distance = sumA - sumB;

        for (int a : A) { // larger -> needs to decrease
            changeCount[a - 1]++;
        }
        for (int b : B) { // smaller -> needs to increase
            changeCount[6 - b]++;
        }
        for (int change = 5; change > 0; change--) {
            for (int time = changeCount[change]; time > 0; time--) {
                distance -= change;
                steps++;
                if (distance <= 0) {
                    return steps;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 5 }, new int[] { 1, 1, 6 })); // 1
        System.out.println(solution(new int[] { 2, 3, 1, 1, 2 }, new int[] { 5, 4, 6 })); // 2
        System.out.println(solution(new int[] { 5, 4, 1, 2, 6, 5 }, new int[] { 2 })); // 6
        System.out.println(solution(new int[] { 1, 2, 3, 4, 3, 2, 1 }, new int[] { 6 })); // -1
        System.out.println(solution(new int[] { 2, 2 }, new int[] { 2 })); // 1
    }
}
