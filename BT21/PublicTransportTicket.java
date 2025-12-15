package BT21;

public class PublicTransportTicket {
    public static int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length <= 3) {
            return A.length * 2;
        }
        if (A.length >= 23) {
            return 25;
        }
        int[] memoization = new int[A.length];
        return Math.min(25, DP(A, 0, memoization));
    }

    public static int DP(int[] A, int index, int[] memoization) {
        if (index >= A.length) {
            return 0;
        }
        if (memoization[index] != 0) {
            return memoization[index];
        }
        int indexAfterAWeek = index;
        while (indexAfterAWeek < A.length && A[indexAfterAWeek] <= A[index] + 6) {
            indexAfterAWeek++;
        }
        int sevenDayTicket = 7 + DP(A, indexAfterAWeek, memoization);
        int oneDayTicket = 2 + DP(A, index + 1, memoization);
        memoization[index] = Math.min(sevenDayTicket, oneDayTicket);
        return memoization[index];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,4,5,7,39,30})); // 11
        System.out.println(solution(new int[]{1,2,3, 7,8,9,10,11,12,13, 17,18,19})); // 19 (1 7-day, 6 1-day)
        System.out.println(solution(new int[]{1,2,3,6,7,8,9,10,11,12,14,15,16})); // 18 (2 7-day, 2 1-day)
        System.out.println(solution(new int[]{1,4,5,6,7,8,9,10,12,13,14,16,17,18,19,20,21,22})); // 21
        System.out.println(solution(new int[]{1,2,3})); // 6
    }
}
