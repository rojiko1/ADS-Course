package Part1.Week1.HelloWorld;

import java.util.Scanner;

public class HelloGoodbye {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String name1 = scanner.nextLine();
        System.out.println("Enter second name: ");
        String name2 = scanner.nextLine();
        helloGoodbye(name1, name2);
    }

    public static void helloGoodbye(String name1, String name2) {
        System.out.println("Hello " + name1 + " and " + name2);
        System.out.println("Goodbye " + name2 + " and " + name1);
    }

}
