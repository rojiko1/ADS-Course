package Part1.Week2.LinkedList;

public class LinkedList {

    private Node head;

    public LinkedList() {
        head = new Node();
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public void addFront(Node node) {
        node.setNext(head);
        head = node;
    }

    public void addEnd(Node node) {
        Node current = head;
        Node next = current.getNext();
        while (next != null) {
            current = next;
            next = current.getNext();
        }
        current.setNext(node);
    }

    public void addAtPosition(Node node, int position) {
        if (position < 1) {throw new IllegalArgumentException();}
        else if (position == 1) {addFront(node);}
        else {
            Node current = head;
            for (int i = 1; i < position; i++) {
                Node next = current.getNext();
                if (next == null) {throw new IllegalArgumentException();}
                else {current = next;}
            }
            node.setNext(current.getNext());
            current.setNext(node);
        }
    }

    public void remove(int position) {
        if (position < 1) {throw new IllegalArgumentException();}
        else if (position == 1) {head = head.getNext();}
        else {
            Node current = head;
            for (int i = 1; i < position; i++) {
                Node next = current.getNext();
                if (next == null) {throw new IllegalArgumentException();}
                else {current = next;}
            }
            if (current.getNext() == null) {throw new IllegalArgumentException();}
            else {
                current.setNext(current.getNext().getNext());
            }
        }
    }

    public void remove(Node node) {
        if (head == node) {head = head.getNext();}
        else {
            Node current = head;
            Node next = current.getNext();
            while (next != null) {
                if (next == node) {
                    current.setNext(next.getNext());
                    break;
                }
            }
        }
    }

}
