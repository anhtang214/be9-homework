package BT18;

import java.util.LinkedList;

public class Be9BSTree {
    public TreeNode root;

    public TreeNode BFS(int value) {
        System.out.print("BFS: ");

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

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

    public TreeNode DFSIterative(int value) {
        System.out.print("DFS Iterative: ");

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeLast();
            if (node.value == value) {
                System.out.println(node.value);
                return node;
            }
            System.out.print(node.value + ",");
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return null;
    }

    public TreeNode DFSRecursive(int value) {
        System.out.print("DFS Recursive: ");
        return searchDFSRecursive(root, value);
    }

    public TreeNode searchDFSRecursive(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            System.out.println(node.value);
            return node;
        }
        System.out.print(node.value + ",");
        TreeNode findLeft = searchDFSRecursive(node.left, value);
        if (findLeft != null) {
            return findLeft;
        }
        TreeNode findRight = searchDFSRecursive(node.right, value);
        if (findRight != null) {
            return findRight;
        }
        return null;
    }

    public void addNode(TreeNode node) {
        if (root == null) {
            this.root = node;
            return;
        }
        insert(root, node);
    }

    public TreeNode insert(TreeNode currentNode, TreeNode node) {
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

    public TreeNode balance(TreeNode node) {
        updateHeight(node);
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

    public int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void updateHeight(TreeNode node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public int getBalanceFactor(TreeNode node) {
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     *     y                x
     *    / \              / \
     *   x  T3   -->>     T1  y
     *  / \                  / \
     * T1 T2                T2 T3
     */
    public TreeNode rotateRight(TreeNode y) {
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
    public TreeNode rotateLeft(TreeNode x) {
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