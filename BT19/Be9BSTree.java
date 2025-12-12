package BT19;

import java.util.LinkedList;

public class Be9BSTree {
    public TreeNode root;

    public TreeNode BFS(int value) {
        System.out.print("BFS: ");

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node.value == value) {
                System.out.println(node.value);
                return node;
            }
            System.out.print(node.value + ",");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return null;
    }

    public void addNode(TreeNode node) {
        if (this.root == null) {
            this.root = node;
            return;
        }
        insert(this.root, node);
    }

    private TreeNode insert(TreeNode currentNode, TreeNode node) {
        if (currentNode == null) {
            return node;
        }
        if (node.value < currentNode.value) {
            currentNode.left = insert(currentNode.left, node);
        } else {
            currentNode.right = insert(currentNode.right, node);
        }
        return balance(currentNode);
    }

    private TreeNode balance(TreeNode node) {
        updateHeight(node);
        // System.out.println("Node value: " + node.value + ", Height: " + node.height);
        int bf = getBalanceFactor(node);
        if (bf > 1) {
            if (getBalanceFactor(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        } else if (bf < -1) {
            if (getBalanceFactor(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }
        return node;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private void updateHeight(TreeNode node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private int getBalanceFactor(TreeNode node) {
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     *     y                x
     *    / \              / \
     *   x  T3   -->>     T1  y
     *  / \                  / \
     * T1 T2                T2 T3
     */
    private TreeNode rotateRight(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;
        y.left = T2;
        x.right = y;
        updateHeight(y);
        updateHeight(x);
        if (this.root.value == y.value) {
            this.root = x;
        }
        return x;
    }

    /**
     *     x                y
     *    / \              / \
     *  T1   y   -->>     x   T3
     *      / \          / \
     *     T2 T3        T1 T2
     */
    private TreeNode rotateLeft(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;
        x.right = T2;
        y.left = x;
        updateHeight(x);
        updateHeight(y);
        if (this.root.value == x.value) {
            this.root = y;
        }
        return y;
    }
}
