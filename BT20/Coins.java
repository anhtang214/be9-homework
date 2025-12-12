package BT20;

public class Coins {
    public static int solution(int[] coins) {
        // Time complexity: O(n)
        int pairs = 0;
        boolean has010or101 = false;
        for (int i = 0; i < coins.length - 1; i++) {
            if (coins[i] == coins[i+1]) {
                pairs++;
            }   
            if (i < coins.length - 2 && coins[i] != coins[i+1] && coins[i+1] != coins[i+2]) {
                has010or101 = true;
            }
        }
        if (pairs == coins.length - 1) {
            return pairs - 1;
        }
        if (has010or101) {
            return pairs + 2;
        }
        return pairs;
    }

    public static void main(String[] args) {
        // if have 1,0,1, or 0,1,0 -> +2
        System.out.println(solution(new int[]{1,1,0,1,0,0,1,1})); // 5
        // if all numbers the same -> -1
        System.out.println(solution(new int[]{1,1,1,1,1})); // 3
        // else, return pairs
        System.out.println(solution(new int[]{1,1,0,0,0,0,1,1})); // 5
    }
}
