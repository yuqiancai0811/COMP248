//Assignment 1 Question 2
//Written by: Yuqian Cai

//general explanation: This program are including two parts. One is like a search system to help customers know how much balance left in their gift card account
//						and how many tickets they can buy by entering their gift card retailer name and their gift card amount. Another is for customers input
//						how many tickets want to buy and then give them an output information like an invoice including the number of tickets, how much redeemed
//						from gift card, the balance left, purchased date,etc.



//Import the Scanner class within a package
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        //Welcome message
        System.out.println("Welcome to the Simple Cinema Tickets Invoice Program:");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

        //Instantiate an object named input of Scanner class and associate System.in as the data source
        Scanner input = new Scanner(System.in);
        //A general description for users to know enter info from here
        System.out.print("Enter the prepaid gift card retailer/bank name: ");
        //For users input a prepaid gift card retailer/ bank name
        String giftCardName = input.nextLine();

        //use string + operator to return the string(giftCardName) become all in upper case
        String nameUpper = giftCardName.toUpperCase();


        System.out.println("You will be using "+ nameUpper + " gift card for your ticket(s) purchase.");

        //A general description for users to know input the gift card amount from here
        System.out.print("Enter the amount on the gift card: ");
        // use method of new Scanner object for users to enter a amount. Amount is not a integer so can use type double
        double giftCardAmount = input.nextDouble();

        //display information by using System.out.println
        System.out.println("There is a fund of $" + giftCardAmount + " on your prepaid " + nameUpper + " gift card.");

        //initialize the ticket price, also not a integer so assigns as double
        double ticketPrice = 6.99;

        //calculate how many the number of tickets can buy, because the result is a double we need to convert by using casting
        int ticketNumCanBuy = (int) (giftCardAmount / ticketPrice);

        //build a variable (balance) and calculate gift card account balance
        double balance = giftCardAmount - ticketPrice * ticketNumCanBuy;
        //Display information by using System.out.print here, can let this line not go to a new line.
        System.out.print("Using your " + nameUpper + " gift card you can purchase " + ticketNumCanBuy);

        //using string+ operator(format) can let the string "balance" control in 2 decimals.
        System.out.println(" tickets and have a balance of $" + String.format("%.2f", balance) + " on the gift card.");

        //input the number of tickets they want to buy，which also is a integer
        System.out.print("Enter the number of tickets you want to purchase: ");
        int ticketNumPurchased = input.nextInt();

        //calculate the cost, cost is not a integer, so assign cost as a double
        double cost = ticketNumPurchased * ticketPrice ;

        //same as string balance, using String.format can control cost only in 2 decimals
        System.out.println("The purchase of " + ticketNumPurchased + " ticket(s) costs $" + String.format("%.2f.", cost));
        //calculate the balance = gift card amount- number of tickets entered * ticket price
        double balanceLeft = giftCardAmount- cost;
        //Using formatted string "%.2f" to let "balanceLeftStr" print only two digits after the decimal point.
        String balanceLeftStr = String.format("$%.2f", balanceLeft);
        System.out.println("The balance left on your " + nameUpper + " gift card is " + balanceLeftStr+".");

        System.out.println("\nPlease enter your purchase info:\n");

        //input day month year
        System.out.print("Day of purchase(between 1 and 31): ");
        int day = input.nextInt();
        System.out.print("Month of purchase(between 1 and 12): ");
        int month = input.nextInt();
        System.out.print("Year of purchase(between 2023 and 2028): ");
        int year = input.nextInt();

        // create a long line by create a String, can decease typing repeated content
        String lines = "------------------------------------------------------------------------------------------";
        //calculate the lines length for later use
        int linesLength = lines.length(); // 90 spaces

        System.out.println(lines);

        //use formatted output,  specify a field width: 40 spaces before the string "Cinema Concordia"
        System.out.printf("%40s", "Cinema Concordia");
        //use formatted print, added 15 spaces before the integer day, and use %n causes subsequent output to continue on a new line.
        System.out.printf("%15d/%d/%d%n%n%n", day, month, year);

        System.out.println(lines);

        // Use string + operator to build string "ticketNumPurchased Tickets", also convenient for getting string length later
        //"%s" is a format specifier for output a string value
        String ticketsNumStr = String.format("%s Tickets", ticketNumPurchased);
        // Use string + operator to build string "$cost"
        String totalCostStr = String.format("$%s", cost);
        //Print in formatted data for adding spaces between two strings
        //the field width = linesLength - ticketsNumStr.length - totalCostStr.length
        //It is an integer value pad between "%" and "s" by following format string
        System.out.printf(ticketsNumStr + " %" + (linesLength - ticketsNumStr.length() - totalCostStr.length() - 1) + "s" + totalCostStr + "\n", "");

        //Using formatted string %.2f to let "cost" print only two digits after the decimal point.
        System.out.println("$"+ String.format("%.2f",cost) + " was redeemed from " + nameUpper + " prepayed gift card.");
        // Use string + operator to build string "nameUpper gift car balance"
        String nameUpperStr = String.format("%s gift card balance", nameUpper);

        //Print in formatted data for adding spaces between two strings
        //the whitespace length = linesLength - nameUpperStr.length- balanceLeftStr.length
        //It is an integer value pad between "%" and "s" by following format string
        //using again: 	String balanceLeftStr = String.format("$%.2f", balanceLeft);
        System.out.printf(nameUpperStr + "%" + (linesLength - nameUpperStr.length() - balanceLeftStr.length()) + "s" + balanceLeftStr + "\n", "" );

        System.out.println("\n"+ lines);

        //closing messages, using"\n" can go to a new line
        System.out.println("Invoice generated successfully.\n\n");
        System.out.println("Thank you for using my bespoke Cinema Tickets Invoice Program!");

        //close the scanner object for saving storage
        input.close();
    }

}
