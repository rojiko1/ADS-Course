package Part1.Week2.Queues;

import java.util.ArrayList;

public class Permutation {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        words.add("Hello");
        words.add("I");
        words.add("am");
        words.add("Rohil");
        permutation(2, words);
    }

    public static void permutation(int k, ArrayList<String> words) {
        if (k > words.size()) {throw new IllegalArgumentException();}
        else {
            RandomizedQueue randQueue = new RandomizedQueue();
            ArrayList<String> rand_words = new ArrayList<String>();
            for (String word : words)
                randQueue.enqueue(word);
            for (int i = 0; i < k; i++) {
                System.out.println((String) randQueue.dequeue());
            }
        }
    }

}
