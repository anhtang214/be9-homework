package suabaiBT19;

import java.util.PriorityQueue;

public class Main {
    public static int solution(int[] A, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(A[i]);
        }
        for (int j = k; j < A.length; j++) {
            minHeap.add(A[j]);
            minHeap.poll();
        }
        return minHeap.poll();
    } 
    
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5,6,2,8,9,1}, 2)); // 8
        System.out.println(solution(new int[]{5,6,2,8,9,1}, 3)); // 6
    }
}
