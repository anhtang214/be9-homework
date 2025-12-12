package BT17.SearchATree;

import java.util.LinkedList;

public class Be9Tree {
    public TreeNode root;

    public TreeNode searchBFS(int value) {
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
            for (TreeNode child : node.children) {
                queue.add(child);
            }
        }
        return null;
    }

    public TreeNode searchDFSIterative(int value) {
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
            for (int i = node.children.size() - 1; i >= 0; i--) {
                TreeNode child = node.children.get(i);
                stack.add(child);
            }
        }
        return null;
    }

    public TreeNode searchDFSRecursive(int value) {
        System.out.print("DFS Recursive: ");
        return DFSRecursive(root, value);
    }

    private TreeNode DFSRecursive(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            System.out.println(node.value);
            return node;
        }
        System.out.print(node.value + ",");
        for (TreeNode child : node.children) {
            TreeNode foundNode = DFSRecursive(child, value);
            if (foundNode != null) {
                return foundNode;
            }
        }
        return null;
    }

}
