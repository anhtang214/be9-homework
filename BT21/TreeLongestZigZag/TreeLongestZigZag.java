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

    public static int solution(Tree tree) {
        int leftZigZag = DFS(tree.root.left, 0, true, true);
        int rightZigZag = DFS(tree.root.right, 0, false, false);
        return Math.max(leftZigZag, rightZigZag);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(10);
        tree.root.left.left = new TreeNode(20);
        tree.root.left.left.left = new TreeNode(6);
        tree.root.right.left = new TreeNode(1);
        tree.root.right.right = new TreeNode(15);
        tree.root.right.right.left = new TreeNode(30);
        tree.root.right.right.right = new TreeNode(8);
        tree.root.right.right.left.right = new TreeNode(9);
        System.out.println(solution(tree)); // 2

        Tree tree2 = new Tree();
        tree2.root = new TreeNode(0);
        tree2.root.left = new TreeNode(1);
        tree2.root.left.left = new TreeNode(3);
        tree2.root.right = new TreeNode(2);
        tree2.root.right.right = new TreeNode(4);
        System.out.println(solution(tree2)); // 0

        Tree tree3 = new Tree();
        tree3.root = new TreeNode(0);
        tree3.root.left = new TreeNode(1);
        tree3.root.left.right = new TreeNode(5);
        tree3.root.right = new TreeNode(2);
        tree3.root.right.left = new TreeNode(6);
        System.out.println(solution(tree3)); // 1
    }
}
