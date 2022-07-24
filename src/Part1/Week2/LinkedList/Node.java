package Part1.Week2.LinkedList;

public class Node<Item> {

    private Item data;
    private Node next;

    public Node() {
        data = null;
        next = null;
    }

    public Node(Item data) {
        this.data = data;
        this.next = null;
    }

    public void setData(Item newData) {data = newData;}

    public void setNext(Node next) {this.next = next;}

    public Item getData() {return data;}

    public Node getNext() {return next;}

}
