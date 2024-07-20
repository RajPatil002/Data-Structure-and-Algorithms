package tree;

public class BinaryTree {
    TreeNode root;

    // NLR
    void preorderTraverse() {
        Traversal.preorderTraverse(root);
    }

    // LNR
    void inorderTraverse() {
        Traversal.inorderTraverse(root);
    }

    // LRN
    void postorderTraverse() {
        Traversal.postorderTraverse(root);
    }

    // BFS
    void bridthFirstSearch() throws Exception {
        Traversal.bridthFirstSearch(root);
    }

    // LeftView
    void leftView() {
        Traversal.leftView(root);
    }

    // RightView
    void rightView() {
        Traversal.rightView(root);
    }

    private TreeNode insert(TreeNode troot, int value) {
        if (troot == null) {
            return new TreeNode(value);
        }
        if (troot.value > value) {
            // System.out.print(troot.value + "L");
            troot.setLeft(insert(troot.getLeft(), value));
        } else if (troot.value < value) {
            // System.out.print(troot.value + "R");
            troot.setRight(insert(troot.getRight(), value));
        }
        return troot;
    }

    void insert(int value) {
        root = insert(root, value);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(4);
        tree.insert(-1);
        tree.insert(3);
        tree.insert(-2);
        tree.insert(8);
        tree.insert(5);
        tree.insert(6);
        tree.insert(0);

        // Tree = 4(-1(-2,3(0L)) , 8(5L(6R)))

        System.out.println("Pre");
        tree.preorderTraverse();
        System.out.println();

        System.out.println("In");
        tree.inorderTraverse();
        System.out.println();

        System.out.println("Post");
        tree.postorderTraverse();
        System.out.println();

        try {
            System.out.println("BFS");
            tree.bridthFirstSearch();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("LeftView");
        tree.leftView();
        System.out.println();

        System.out.println("RightView");
        tree.rightView();
        System.out.println();

    }
}
