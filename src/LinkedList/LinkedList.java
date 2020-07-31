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
    public void print(){
        Node temp =head;
        while(temp!=null) {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}
