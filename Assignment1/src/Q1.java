//Assignment 1 Question 1
//Written by: Yuqian Cai

/* General explanation: This program is for the scalper knowing how much changes they will need to give customers after entered a ticket price. 
 						The number of changes are included each numbers of different values of Crypto coins. 
						The count of changes are from the largest to the smallest denominations. 
*/


//Import the Scanner class within a package

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        //From the output example, firstly display welcome messages.Using System.out.println can print those sentences and automatically goes to the new line.
        System.out.println("Welcome to the Crypto Change Program:");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        //Instantiate an object named keyboard of Scanner class and associate System.in as the data source
        Scanner keyborad = new Scanner(System.in);

        //print a general description for user to know they need to enter a ticket price here
        System.out.print("Enter the price of the ticket in Cryptom(at most 7500): ");

        // use method of new Scanner object for the user to input a ticket price from the keyboard.
        int ticketPrice = keyborad.nextInt();

        // print and display a ticket price the user input and how much change they will get
        System.out.println("\nYou bought a ticket for " + ticketPrice + " Cryptom. and gave me a Pesico, so your change is");

        //initialize the coins' value
        int pesicoVal = 7500;
        int bitomVal = 500;
        int ditomVal = 200;
        int zitomVal = 50;

        //calculate the change = pesico - ticketPrice
        int change = pesicoVal - ticketPrice;
        //calculate the number of bitom
        int bitomNum = change / bitomVal;
        change = change - (bitomNum * bitomVal);
        //calculate the number of ditom
        int ditomNum = change / ditomVal;
        change = change - (ditomNum * ditomVal);
        //calculate the number of zitom
        int zitomNum = change / zitomVal;
        change = change - (zitomNum * zitomVal);
        //calculate the number of cryptom(remaining value)
        int cryptom = change;

        //There are 4 different Crypto coins, so we need to output all the numbers of Bitom, Ditom, Zitom and Cryptom when print the result of change
        System.out.println(bitomNum + " Bitom,\n" + ditomNum + " Ditom,\n" + zitomNum + " Zitom, and\n" + cryptom + " Cryptom.\n\n");

        //print closing message by using "\n" to enter a new line in the output
        System.out.println("""
                Thank you for using my bespoke Crypto Change Program!

                Enjoy the Game!""");

        //close the scanner for saving the storage
        keyborad.close();
    }

}
