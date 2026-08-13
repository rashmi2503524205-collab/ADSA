class Node
{
    int data;
    Node left;
    Node right;

    Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}

class BST
{
    Node root;

    Node insert(Node root, int value)
    {
        if (root == null)
        {
            return new Node(value);
        }

        if (value < root.data)
        {
            root.left = insert(root.left, value);
        }
        else if (value > root.data)
        {
            root.right = insert(root.right, value);
        }

        return root;
    }

    void inorder(Node root)
    {
        if (root != null)
        {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root)
    {
        if (root != null)
        {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root)
    {
        if (root != null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    Node search(Node root, int key)
    {
        if (root == null || root.data == key)
        {
            return root;
        }

        if (key < root.data)
        {
            return search(root.left, key);
        }
        else
        {
            return search(root.right, key);
        }
    }

    public static void main(String[] args)
    {
        BST tree = new BST();
        int[] values = {25, 20, 30, 15, 21, 26, 31};

        for (int i = 0; i < values.length; i++)
        {
            tree.root = tree.insert(tree.root, values[i]);
        }

        System.out.print("Inorder traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Preorder traversal: ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.postorder(tree.root);
        System.out.println();

        int key1 = 30;
        Node result1 = tree.search(tree.root, key1);
        if (result1 != null)
        {
            System.out.println(key1 + " found in the tree");
        }
        else
        {
            System.out.println(key1 + " not found in the tree");
        }

        int key2 = 40;
        Node result2 = tree.search(tree.root, key2);
        if (result2 != null)
        {
            System.out.println(key2 + " found in the tree");
        }
        else
        {
            System.out.println(key2 + " not found in the tree");
        }
    }
}