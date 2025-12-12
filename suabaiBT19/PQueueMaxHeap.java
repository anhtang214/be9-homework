package suabaiBT19;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQueueMaxHeap {
    public static int solution(int[] A, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            maxHeap.add(A[i]);
        }
        for (int j = k; j < A.length; j++) {
            maxHeap.add(A[j]);
            maxHeap.poll();
        }
        return maxHeap.poll();
    } 
    
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5,6,2,8,9,1}, 2)); // 2
        System.out.println(solution(new int[]{5,6,2,8,9,1}, 3)); // 5
    }
}
