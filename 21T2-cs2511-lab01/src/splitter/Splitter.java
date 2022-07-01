package splitter;

import java.util.Scanner;

public class Splitter {


    public static void main(String[] args) {
        System.out.println("Enter a sentence specified by spaces only: ");
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String[] words = sentence.split(" ");
        
        for (String elem : words) {
            System.out.println(elem);
        }
        sc.close();
    }
}
