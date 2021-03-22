package Tree;

public class Node {
    public Node left;
    public Node right;
    public Object data;
    public Node(Object data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
    public Node(){
    }
}
