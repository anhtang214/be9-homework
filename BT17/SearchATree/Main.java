package BT17.SearchATree;

public class Main {
    public static void main(String[] args) {
        Be9Tree tree = new Be9Tree();
        tree.root = new TreeNode(1);
        tree.root.children.add(new TreeNode(2));
        tree.root.children.add(new TreeNode(3));

        tree.root.children.get(0).children.add(new TreeNode(4));
        tree.root.children.get(0).children.add(new TreeNode(5));
        tree.root.children.get(1).children.add(new TreeNode(6));

        TreeNode bfs = tree.searchBFS(6);
        TreeNode dfsiterative = tree.searchDFSIterative(6);
        TreeNode dfsrecursive = tree.searchDFSRecursive(6);
    }
}
