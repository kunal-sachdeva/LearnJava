package Tree;

public class BinaryTree {
    public Node root;
    public BinaryTree(Node root){
        this.root=root;
    }
    public void preorder(Node root){
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
    }
    public void inorder(Node root){
        preorder(root.left);
        System.out.println(root.data);
        preorder(root.right);
    }
    public void postorder(Node root){
        preorder(root.left);
        preorder(root.right);
        System.out.println(root.data);
    }
    public int getHeight(Node root){
        if(root==null)
            return 0;
        int lheight=getHeight(root.left);
        int rheight=getHeight(root.right);
        return lheight>rheight?lheight+1:rheight+1;
    }
    public void levelorder(Node root){

    }

}
