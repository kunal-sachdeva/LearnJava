package LinkedList;

public class printLL {
public static void main(String[] args){
    Node head=new Node(1);
    head.next=new Node(2);
    head.next.next=new Node(3);
    LinkedList ll=new LinkedList(head);

    ll.print();
    ll.reverse();
    ll.print();
}
}
