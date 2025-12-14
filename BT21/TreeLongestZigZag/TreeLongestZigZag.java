package BT21.TreeLongestZigZag;

public class TreeLongestZigZag {
    public static int DFS(TreeNode node, int zigzag, boolean parentTurnedLeft, boolean grandparentTurnedLeft) {
        if (node == null) {
            return zigzag;
        }
        if (parentTurnedLeft != grandparentTurnedLeft) {
            zigzag++;
        }
        // System.out.println("Node: " + node.value + " Zigzag: " + zigzag);
        int leftZigZag = DFS(node.left, zigzag, true, parentTurnedLeft);
        int rightZigZag = DFS(node.right, zigzag, false, parentTurnedLeft);
        return Math.max(leftZigZag, rightZigZag);
    }

    public static int solution(TreeNode root) {
        int leftZigZag = DFS(root.left, 0, true, true);
        int rightZigZag = DFS(root.right, 0, false, false);
        return Math.max(leftZigZag, rightZigZag);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.left.left = new TreeNode(6);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(30);
        root.right.right.right = new TreeNode(8);
        root.right.right.left.right = new TreeNode(9);
        System.out.println(solution(root)); // 2

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(1);
        root2.left.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(4);
        System.out.println(solution(root2)); // 0

        TreeNode root3 = new TreeNode(0);
        root3.left = new TreeNode(1);
        root3.left.right = new TreeNode(5);
        root3.right = new TreeNode(2);
        root3.right.left = new TreeNode(6);
        System.out.println(solution(root3)); // 1
    }
}
