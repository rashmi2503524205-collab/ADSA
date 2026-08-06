import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BSTTraversal {

    Node root;

    // Insert a node into BST
    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // ---------- RECURSIVE TRAVERSALS ----------

    // Inorder: Left -> Root -> Right (gives sorted order in BST)
    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder: Root -> Left -> Right
    void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder: Left -> Right -> Root
    void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // ---------- ITERATIVE TRAVERSALS (using Stack) ----------

    void inorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    void preorderIterative(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.data + " ");
            // push right first so left is processed first
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }

    void postorderIterative(Node root) {
        if (root == null) return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null) stack1.push(curr.left);
            if (curr.right != null) stack1.push(curr.right);
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    // ---------- MAIN ----------

    public static void main(String[] args) {
        BSTTraversal tree = new BSTTraversal();
        int[] values = {20,11,25,9,12,22,27};

        for (int v : values) {
            tree.root = tree.insert(tree.root, v);
        }

        System.out.print("Inorder (recursive):   ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Preorder (recursive):  ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Postorder (recursive): ");
        tree.postorder(tree.root);
        System.out.println();

        System.out.print("Inorder (iterative):   ");
        tree.inorderIterative(tree.root);
        System.out.println();

        System.out.print("Preorder (iterative):  ");
        tree.preorderIterative(tree.root);
        System.out.println();

        System.out.print("Postorder (iterative): ");
        tree.postorderIterative(tree.root);
        System.out.println();
    }
}