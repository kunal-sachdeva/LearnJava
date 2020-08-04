package LinkedList;

public class LinkedList {
    public Node head;
    public LinkedList(Node head){
        this.head=head;
    }
    public void reverse(){
        Node curr=head;
        Node next=null;
        Node prev=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public static void recursiveReverse(){

    }
    public void print(){
        Node temp =head;
        while(temp!=null) {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public void insert(Node node){
        Node temp=this.head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
    }
}
