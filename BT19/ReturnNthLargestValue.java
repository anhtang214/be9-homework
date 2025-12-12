package BT19;

import java.util.ArrayList;

public class ReturnNthLargestValue {
    public static void reversedInOrder(TreeNode node, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }
        reversedInOrder(node.right, path);
        path.add(node.value);
        reversedInOrder(node.left, path);
    }

    public static int solution(int[] A, int n) {
        if (n > A.length || n < 0) {
            return -1;
        }
        Be9BSTree tree = new Be9BSTree();
        for (int num : A) {
            tree.addNode(new TreeNode(num));
            
        }
        tree.BFS(9);
        ArrayList<Integer> path = new ArrayList<>();
        reversedInOrder(tree.root, path);
        
        System.out.println(path.toString());
        return path.get(n - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5,6,2,8,9,1}, 2));
        System.out.println(solution(new int[]{5,6,2,8,9,1}, 3));
    }
}
