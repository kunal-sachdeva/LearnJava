package Tree;

public class Utility {
    public Node ConvertBST(Node bt){
        bt.data=rightSumTree(bt);
        return bt;
    }
    public int rightSumTree(Node bt){
        if(bt==null)
            return 0;
        else if(bt.right==null && bt.left==null)
            return (int) bt.data;
        else if(bt!=null && bt.right!=null){
            bt.data=(int)bt.data+rightSumTree(bt.right);
        }
        return (int) bt.data;
    }
}
