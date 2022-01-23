package Tree;

import java.util.Stack;

public class BinaryTree {
    public Node root;
    public BinaryTree(Node root){
        this.root=root;
    }
    public BinaryTree(){
    }
    public void preorder(Node root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public void postorder(Node root){
        if(root==null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public int getHeight(Node root){
        if(root==null)
            return 0;
        int lheight=getHeight(root.left);
        int rheight=getHeight(root.right);
        return lheight>rheight?lheight+1:rheight+1;
    }
    public void levelorder(Node root){
        int height=getHeight(root);
        for(int i=1; i<=height; i++){
            printLevel(root,i);
        }
    }
    public void printLevel(Node root, int level){
        if(root==null)
            return;
        else if(level==1){
            System.out.print(root.data+" ");
        }
        else{
            printLevel(root.left,level-1);
            printLevel(root.right,level-1);
        }
    }
    public int sumTree(Node root){
        if(root==null)
            return 0;
        int oldVal= (int) root.data;
        root.data=sumTree(root.left)+sumTree(root.right);
        return (int)root.data+oldVal;
    }
    public void zigZagPrint(Node root){
        Stack<Node>currentLevel=new Stack<>();
        Stack<Node>nextLevel=new Stack<>();
        Stack<Node>tempStack=new Stack<>();
        Boolean leftToRight=false;
        currentLevel.push(root);
            while (!currentLevel.empty()) {
                Node temp = currentLevel.pop();
                System.out.print(temp.data + " ");
                if (leftToRight) {
                    if (temp.right!=null)
                    nextLevel.push(temp.right);
                    if (temp.right!=null)
                    nextLevel.push(temp.left);
                } else{
                    if (temp.right!=null)
                        nextLevel.push(temp.left);
                    if (temp.right!=null)
                        nextLevel.push(temp.right);
                }

                if(currentLevel.empty()){
                    leftToRight=!leftToRight;
                    tempStack=currentLevel;
                    currentLevel=nextLevel;
                    nextLevel=tempStack;
                }
            }
    }
    public Node mirror(Node root){
        if(root==null)
           return null;
        root.left=mirror(root.left);
        root.right= mirror(root.right);
        Node temp=root.right;
        root.right=root.left;
        root.left=temp;
        return root;
    }

}
