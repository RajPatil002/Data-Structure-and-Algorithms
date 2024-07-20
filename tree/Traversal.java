package tree;

import linkedlist.LinkedList;

public class Traversal {

    // Root -> Left -> Right
    public static void preorderTraverse(TreeNode root) {
        System.out.print(root.value + " ");
        if (root.hasLeft())
            preorderTraverse(root.getLeft());

        if (root.hasRight())
            preorderTraverse(root.getRight());
    }

    // Left -> Root -> Right
    public static void inorderTraverse(TreeNode root) {
        if (root.hasLeft()) {
            inorderTraverse(root.getLeft());
        }
        System.out.print(root.value + " ");
        if (root.hasRight()) {
            inorderTraverse(root.getRight());
        }
    }

    // Left-> Right -> Root
    public static void postorderTraverse(TreeNode root) {
        // Tree = 4(-1(-2,3) , 8(5L))
        if (root.hasLeft()) {
            postorderTraverse(root.getLeft());
        }
        if (root.hasRight()) {
            postorderTraverse(root.getRight());
        }
        System.out.print(root.value + " ");
    }

    // Level Order Search - (Top to Bottom, Left to Right)
    public static void bridthFirstSearch(TreeNode root) throws Exception {

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.insert(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.pop();
            if (current.hasLeft())
                queue.insert(current.getLeft());
            if (current.hasRight())
                queue.insert(current.getRight());
            System.out.print(current.value + " ");
        }

    }

    private static void hideRight(TreeNode right) {
        if (right.hasLeft()) {
            leftView(right.getLeft());
        }
        if (right.hasRight()) {
            hideRight(right.getRight());
        }
    }

    public static void leftView(TreeNode root) {
        System.out.print(root.value + " ");
        if (root.hasLeft()) {
            leftView(root.getLeft());
        }
        if (root.hasRight()) {
            hideRight(root.getRight());
        }
    }

    private static void hideLeft(TreeNode right) {
        if (right.hasLeft()) {
            hideLeft(right.getLeft());
        }
        if (right.hasRight()) {
            rightView(right.getRight());
        }
    }

    public static void rightView(TreeNode root) {
        System.out.print(root.value + " ");
        if (root.hasLeft()) {
            hideLeft(root.getLeft());
        }
        if (root.hasRight()) {
            rightView(root.getRight());
        }
    }

}
