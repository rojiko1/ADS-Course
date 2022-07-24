package Part1.Week1.HelloWorld;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextWord;
        ArrayList<String> words = new ArrayList<String>();
        while (true) {
            System.out.println("Enter next word:");
            nextWord = scanner.nextLine();
            if (nextWord.equals("Done")) {
                break;
            }
            else {
                words.add(nextWord);
            }
        }
        selectRandomWord(words);
    }

    public static void selectRandomWord(ArrayList<String> words) {
        Random rand = new Random();
        String champion = words.get(0);
        for (int i = 1; i < words.size(); i++) {
            if (rand.nextDouble() < (1.0 / ((double) i + 1.0))) {
                champion = words.get(i);
            }
        }
        System.out.println("Random word: " + champion);
    }

}
