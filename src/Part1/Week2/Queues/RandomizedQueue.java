package Part1.Week2.Queues;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private ArrayList<Item> randQueue;
    private Random rand = new Random();

    public RandomizedQueue() {
        randQueue = new ArrayList<>();
    }

    public boolean isEmpty() {return this.size() == 0;}

    public int size() {return randQueue.size();}

    public void enqueue(Item item) {
        if (item == null) {throw new IllegalArgumentException();}
        else {randQueue.add(item);}
    }

    public Item dequeue() {
        if (this.isEmpty()) {throw new NoSuchElementException();}
        else {
            int index = randomIndex();
            Item item = randQueue.get(index);
            randQueue.remove(index);
            return item;
        }
    }

    public Item sample() {
        if (this.isEmpty()) {throw new NoSuchElementException();}
        else {return randQueue.get(randomIndex());}
    }

    private int randomIndex() {return rand.nextInt(this.size());}
    
    public Iterator<Item> iterator() {return new RandomizedQueueIterator();}

    private class RandomizedQueueIterator implements Iterator<Item> {
        
        private ArrayList<Item> clone = new ArrayList<>(randQueue);

        public boolean hasNext() {return clone.size() > 0;}

        public Item next() {
            if (!this.hasNext()) {throw new NoSuchElementException();}
            else {
                int index = rand.nextInt(clone.size());
                Item item = clone.get(index);
                clone.remove(index);
                return item;
            }
        }

        @Override
        public void remove() {throw new UnsupportedOperationException();}
    }
    
    public static void main(String[] args) {
        RandomizedQueue randQueue = new RandomizedQueue();
        System.out.println(randQueue.isEmpty());
        randQueue.enqueue("My");
        randQueue.enqueue("name");
        randQueue.enqueue("is");
        randQueue.enqueue("Rohil");
        System.out.println(randQueue.size());
        for (Object i : randQueue)
            System.out.println(i);
        System.out.println(randQueue.isEmpty());
        System.out.println(randQueue.sample());
        randQueue.dequeue();
        randQueue.dequeue();
        randQueue.dequeue();
        randQueue.dequeue();
        System.out.println(randQueue.isEmpty());
    }

}
