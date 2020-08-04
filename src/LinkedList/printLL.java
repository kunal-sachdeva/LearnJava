package LinkedList;

public class printLL {
public static void main(String[] args){
    /*LinkedList ll=new LinkedList(new Node(1));
    ll.insert(new Node(2));
    ll.insert(new Node(3));
    ll.print();*/
    DoublyLinkedList ll=new DoublyLinkedList(new Nodes(1));
    ll.insert(new Nodes(2));
    ll.insert(new Nodes(3));
    ll.print();
    //ll.reverse();
    //ll.print();
}
}
