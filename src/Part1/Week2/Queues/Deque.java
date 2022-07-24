package Part1.Week2.Queues;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private ArrayList<Item> deque;

    public Deque() {deque = new ArrayList<>();}

    public boolean isEmpty() {return this.size() == 0;}

    public int size() {return deque.size();}

    public void addFirst(Item item) {
        if (item == null) {throw new IllegalArgumentException();}
        else {deque.add(0, item);}
    }

    public void addLast(Item item) {
        if (item == null) {throw new IllegalArgumentException();}
        else {deque.add(item);}
    }

    public Item removeFirst() {
        if (this.isEmpty()) {throw new NoSuchElementException();}
        else {
            Item item = deque.get(0);
            deque.remove(0);
            return item;
        }
    }

    public Item removeLast() {
        if (this.isEmpty()) {throw new NoSuchElementException();}
        else {
            Item item = deque.get(this.size() - 1);
            deque.remove(this.size() - 1);
            return item;
        }
    }

    public Iterator<Item> iterator() {return new DequeIterator();}

    private class DequeIterator implements Iterator<Item> {

        private int currentIndex = 0;
        @Override
        public boolean hasNext() {return currentIndex < deque.size();}

        @Override
        public Item next() {
            if (!this.hasNext()) {throw new NoSuchElementException();}
            else {
                Item item = deque.get(currentIndex);
                currentIndex++;
                return item;
            }
        }

        @Override
        public void remove() {throw new UnsupportedOperationException();}
    }

    public static void main(String[] args) {
        Deque deque = new Deque();
        System.out.println(deque.isEmpty());
        deque.addFirst("name");
        deque.addFirst("My");
        deque.addLast("is");
        deque.addLast("Rohil");
        System.out.println(deque.size());
        for (Object i : deque)
            System.out.println(i);
        deque.removeFirst();
        deque.removeFirst();
        deque.removeLast();
        deque.removeLast();
        System.out.println(deque.isEmpty());
    }

}