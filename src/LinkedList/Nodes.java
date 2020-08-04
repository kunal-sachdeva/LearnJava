package LinkedList;

public class Nodes {
    public Object data;
    public Nodes prev;
    public Nodes next;
    public Nodes(Object data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
