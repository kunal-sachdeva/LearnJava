package Tree;

public class Test {
    public static void main(String[] args){
        Node root= new Node(1);
        root.left= new Node(3);
        root.right= new Node(2);
        root.right.left= new Node(5);
        root.right.right= new Node(4);
        BinaryTree tree = new BinaryTree(root);
        root=tree.mirror(root);
        tree.inorder(root);
    }
}
