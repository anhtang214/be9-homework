package BT18;

public class Main {
    public static void main(String[] args) {
        Be9BSTree tree = new Be9BSTree();
        //        5                3
        //       / \              / \
        //      3   6            2   5
        //     / \       -->    /   / \
        //    2   4            1   4   6
        //   /
        //  1                 

        tree.addNode(new TreeNode(5));
        TreeNode node3 = new TreeNode(3);
        tree.addNode(node3);
        
        tree.addNode(new TreeNode(6));
        
        tree.addNode(new TreeNode(2));
        
        tree.addNode(new TreeNode(4));
        // tree.BFS(3); // 5,3,6,2,4
        // System.out.println(",1: " + tree.root.right.value);/
        // System.out.println(",1: " + node4.right.value);
        tree.addNode(new TreeNode(1));

        // System.out.println(",2: " + node4.right.value);
        tree.BFS(6); // 3,2,5,1,4,6
    }

}
