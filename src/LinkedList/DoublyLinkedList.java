package LinkedList;

public class DoublyLinkedList {
    public Nodes head;
    public DoublyLinkedList(Nodes head){
        this.head=head;
    }
    public void insert(Nodes nodes){
        Nodes temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=nodes;
        nodes.prev=temp;
    }
    public void print(){
        Nodes temp =head;
        while(temp!=null) {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}
