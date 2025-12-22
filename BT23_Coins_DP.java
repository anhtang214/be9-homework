public class BT23_Coins_DP {
    public static int coinsTopDown(int money, int[] coins, int[] memo) {
        if (memo[money] != 0) {
            return memo[money];
        }
        if (money == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (money >= coin) {
                count = Math.min(count, 1 + coinsTopDown(money - coin, coins, memo));
            }
        }
        memo[money] = count;
        return count;
    }

    public static int coinsBottomUp(int money, int[] coins) {
        int[] memo = new int[money + 1];
        for (int i = 0; i < money; i++) {
            for (int coin : coins) {
                int nextIndex = i + coin;
                if (nextIndex <= money) {
                    if (memo[nextIndex] == 0) {
                        memo[nextIndex] = memo[i] + 1;
                    } else {
                        memo[nextIndex] = Math.min(memo[nextIndex], memo[i] + 1);
                    }
                }
            }
        }
        return memo[money];
    }

    public static void main(String[] args) {
        int money = 6;
        int[] memo = new int[money + 1];
        System.out.println(coinsTopDown(money, new int[]{1,3,4}, memo)); // 2
        System.out.println(coinsBottomUp(money, new int[]{1,3,4})); // 2
        int money2 = 8;
        int[] memo2 = new int[money2 + 1];
        System.out.println(coinsTopDown(money2, new int[]{1,4,5}, memo2)); // 2
        System.out.println(coinsBottomUp(money2, new int[]{1,4,5})); // 2
    }
}
