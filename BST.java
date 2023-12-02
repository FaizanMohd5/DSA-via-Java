public class BST {
    /*1. Class 'BST(Binary Search Tree) with Node type reference variable root '
         as member variable. Implement Binary Search Tree using Linked List
         Representation. */
    private Node root;
    public static class Node{
        private Node left;
        private int data;
        private Node right;
        public Node getLeft() {
            return left;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public Node getRight() {
            return right;
        }
        public void setRight(Node right) {
            this.right = right;
        }
    }

    //2. Check if tree is empty.
    public boolean isTreeEmpty(){
        return this.root==null;
    }

    //3. Insert a new node in BST.

    // Iterative Approach
    public void insertNode(int data){
        Node newNode = new Node();
        newNode.setLeft(null);
        newNode.setData(data);
        newNode.setRight(null);
        if(isTreeEmpty())
            root = newNode;
        else {
            Node ptr = root;
            while(true) {
                if(ptr.data < data){
                    if(ptr.getRight()!=null)
                        ptr = ptr.getRight();
                    else{
                        ptr.setRight(newNode);
                        return;
                    }
                }
                else if(ptr.data > data){
                    if(ptr.getLeft()!=null)
                        ptr = ptr.getLeft();
                    else{
                        ptr.setLeft(newNode);
                        return;
                    }
                }
                else{
                    System.out.println(data+" is already present in the tree.");
                }
            }
        }
    }

    //4. Preorder traversal
    public void preorderTraversal(Node root) {
        if(root!=null) {
            System.out.print(" " + root.getData());
            preorderTraversal(root.getLeft());
            preorderTraversal(root.getRight());
        }
    }

    //5. Inorder traversal
    public void inorderTraversal(Node root) {
        if(root!=null) {
            inorderTraversal(root.getLeft());
            System.out.print(" " + root.getData());
            inorderTraversal(root.getRight());
        }
    }

    //6. Postorder traversal
    public void postorderTraversal(Node root) {
        if(root!=null) {
            postorderTraversal(root.getLeft());
            postorderTraversal(root.getRight());
            System.out.print(" " + root.getData());
        }
    }

    //7. Delete a node from BST

    //Iterative Approach
    public void deleteNode(int data){
        root = deleteOperation(root, data);
    }

    private Node deleteOperation(Node ptr, int data){
        if(isTreeEmpty())
            return null;
        else{
            if(ptr.data > data)
                ptr.left = deleteOperation(ptr.getLeft(), data);
            else if(ptr.data < data)
                ptr.right = deleteOperation(ptr.getRight(), data);
            else{
                if(ptr.getLeft()==null && ptr.getRight()==null){
                    return null;
                }
                else if(ptr.getRight()==null){
                    return ptr.getLeft();
                }
                else if(ptr.getLeft()==null){
                    return ptr.getRight();
                }
                Node minNode = getMinElement(ptr.getRight());
                ptr.data = minNode.data;
                ptr.right = deleteOperation(ptr.right,ptr.data);
            }
        }
        return ptr;
    }

    private Node getMinElement(Node ptr){
        if(isTreeEmpty() || ptr==null)
            return null;
        while(ptr.left!=null)
            ptr=ptr.getLeft();
        return ptr;
    }
    private Node getMaxElement(Node ptr){
        if(isTreeEmpty() || ptr==null)
            return null;
        while(ptr.right!=null)
            ptr = ptr.getRight();
        return ptr;
    }


    //8. Search a node in BST
    public Node searchNode(int data){
        Node ptr = root;
        while(ptr!=null){
            if(ptr.getData() < data)
                ptr = ptr.getRight();
            else if(ptr.getData() > data)
                    ptr = ptr.getLeft();
            else
                return ptr;
        }
        return null; //data nai mila
    }

    //9. Find max element in BST
    public Node maximumElement(){
        if(getMaxElement(root)==null){
            System.out.println("Tree is empty.");
            return null;
        }
        return getMaxElement(root);
    }

    //10. Find min element in BST
    public Node minimumElement(){
        if(getMinElement(root)==null){
            System.out.println("Tree is empty.");
            return null;
        }
        return getMinElement(root);
    }

    //driver
    public void driver(){
        BST tree = new BST();
        tree.insertNode(60);
        tree.insertNode(40);
        tree.insertNode(50);
        tree.insertNode(20);
        tree.insertNode(90);
        tree.insertNode(80);
        tree.insertNode(100);
        tree.insertNode(70);
        tree.insertNode(85);
        tree.insertNode(65);
        tree.preorderTraversal(tree.root);
        System.out.println();
        tree.inorderTraversal(tree.root);
        System.out.println();
        tree.postorderTraversal(tree.root);
        System.out.println();

        tree.deleteNode(60);
        tree.inorderTraversal(tree.root);
    }
}
