// --------------------------------------------------------------------
// Assignment 3 Question 1
// Written by: Yuqian Cai
// --------------------------------------------------------------------

import java.util.Scanner;

public class A3_Q1 {

    public static void main(String[] args) {

        //welcome message
        System.out.println("____****_______****_______****_______****_______****___");
        System.out.println("Welcome to the Simple Brilliant Mind Game Jackpot!");
        System.out.println("____****_______****_______****_______****_______****___");
        System.out.println();
        // Variable declarations.
        int age; int scoreValue = 0; int categoriesNumber;
        int eachLine = 10; int count = 0; int sum = 0;
        String category;
        boolean old = false;
        //prompt the user for age input
        Scanner input = new Scanner(System.in);

        System.out.println("How old are you?");
        //use hasNextInt to judge the user's input
        while (!old && input.hasNextInt()) {
            age = input.nextInt();
            //if age is not from15 to 125 then,let user to enter again.
            if (age < 15 || age > 125) {
                System.out.println("Error:Your input/entry is not valid integer between 15 and 125. Kindly retry again!");
                System.out.println("How old are you?");
            } else
                //if user input is correct, let boolean old be true, and while loop will be finished.
                old = true;
        }
        System.out.println();
        System.out.println("____****_______****_______****_______****_______****____");
        System.out.println("      Your Jackpot for the Simple Brilliant Mind game is:");
        System.out.println("____****_______****_______****_______****_______****____");
        System.out.println();
        System.out.println();
        System.out.println();
        //there are a nested for loop with a switch.
        // the outside for loop is for print all 10 categeries by table.
        for (categoriesNumber = 1; categoriesNumber <= 10; categoriesNumber++) {
            // using switch, to assign all contents from table.
            // if categoriesNumber equals  1,2,3..10, then the category and score value will be assigned one by one.
            switch (categoriesNumber) {
                case 1 -> {
                    category = "Science";
                    scoreValue = 19;
                }
                case 2 -> {
                    category = "Literature";
                    scoreValue = 18;
                }
                case 3 -> {
                    category = "Sports";
                    scoreValue = 19;
                }
                case 4 -> {
                    category = "Animals";
                    scoreValue = 20;
                }
                case 5 -> {
                    category = "Television";
                    scoreValue = 19;
                }
                case 6 -> {
                    category = "Music";
                    scoreValue = 18;
                }
                case 7 -> {
                    category = "Business";
                    scoreValue = 19;
                }
                case 8 -> {
                    category = "Geography";
                    scoreValue = 19;
                }
                case 9 -> {
                    category = "Cities";
                    scoreValue = 18;
                }
                case 10 -> {
                    category = "Opera";
                    scoreValue = 19;
                }
                default -> category = null;
            }
            System.out.println("In the score of " + category + " , the numbers that are not multiple of category " + categoriesNumber + " are:");
            // this for loop is for let i increment  from 1 to score value,
            // and using if statement to judge all numbers' reminder are not 0, then print them.
            // and using sum is equal to add all those numbers.
            for (int i = 1; i <= scoreValue; i++) {
                if (i % categoriesNumber != 0) {
                    System.out.print(i + ", ");
                    count++;
                    sum += i;
                    //int count can record how many numbers(i),
                    // when there is 10 numbers(count=10) which means go to a new line.
                    if (count == eachLine) {
                        System.out.println();
                    }
                }
            }
            // every time finish the inside (category) for loop,the int count need to be initialized as 0 again.
            count = 0;
            //if the sum is 0, means there is no i's reminder is equal to other numbers rather than 0 from that inside loop .
            if (sum == 0)
                System.out.println("No numbers are found in this category!==> The Cryptom value 0.");
            else
                System.out.println("==> The Cryptom value " + sum + ".");
            System.out.println();
        }
        //close message, just print once which is not in the for loop.
        System.out.println("Thank you for using my bespoke the Simple Brilliant Mind Game Jackpot Program!");

        input.close();

    }
}
