package BT11;

public class EvenPairsOnCycle {
    public static int evenPairsOnCycle(int[] A) {
        int pairs = 0;
        for (int i = 0; i < A.length; i++) {
            int nextIndex = (i + 1) % A.length;
            if (A[i] % 2 == A[nextIndex] % 2) {
                pairs++;
                i++;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] A1 = {4,2,5,8,7,3,7};
        int[] A2 = {14,31,16,35,22};
        int[] A3 = {5,5,5,5,5,5};
        System.out.println(evenPairsOnCycle(A1));
        System.out.println(evenPairsOnCycle(A2));
        System.out.println(evenPairsOnCycle(A3));
    }
}
