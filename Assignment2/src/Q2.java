/**
 * @programDescription Dynamic Latency-Computer Program
 * A basic program for computing the Latency (in milliseconds) incurred during the transfer of a predefined
 * quantity of data, between any two (2) nodes, either via a given bandwidth channel/link or latency
 * specification within the Project-S Metropolitan Area Network (MAN).
 */

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        // Prints a welcome message
        System.out.println("Welcome to the Dynamic Latency-Computer Program:");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");

        // Variable declarations
        String weekDay, modeSelect, dataAmt;
        double bndWdthQty = 0.0, dataAmtQty = 0.0, latVal, secsVal;
        int errFlag = 0;
        Scanner inputScanner = new Scanner(System.in); // Open a Scanner object

        // Prompt the user for inputs, viz: weekday, mode, and data-amount
        System.out.print("\nPlease enter a Weekday, Mode, and Data Quantity, respectively: ");
        weekDay = inputScanner.next().toLowerCase();
        modeSelect = inputScanner.next().toLowerCase();
        dataAmt = inputScanner.next().toLowerCase();

        // Preprocessing: input data
        if (modeSelect.equals("latency")) {
            bndWdthQty = 10.0 * Math.pow(2, 30) * 8.0;
            switch (weekDay) {
                case "monday" -> {
                    secsVal = (8.0 * Math.pow(10, -6)) / 1000.0;
                    bndWdthQty = bndWdthQty / secsVal;
                }
                case "tuesday" -> {
                    secsVal = (8.8 * Math.pow(10, -21)) / 1000.0;
                    bndWdthQty = bndWdthQty / secsVal;
                }
                case "wednesday" -> {
                    secsVal = (8.0 * Math.pow(10, -7)) / 1000.0;
                    bndWdthQty = bndWdthQty / secsVal;
                }
                case "thursday" -> {
                    secsVal = (3.2 * Math.pow(10, -10)) / 1000.0;
                    bndWdthQty = bndWdthQty / secsVal;
                }
                case "friday" -> {
                    secsVal = (8.8 * Math.pow(10, -12)) / 1000.0;
                    bndWdthQty = bndWdthQty / secsVal;
                }
                case "saturday" -> {
                    secsVal = (7.2 * Math.pow(10, -15)) / 1000.0;
                    bndWdthQty = bndWdthQty / secsVal;
                }
                case "sunday" -> {
                    secsVal = (5.3 * Math.pow(10, -18)) / 1000.0;
                    bndWdthQty = bndWdthQty / secsVal;
                }
                default -> errFlag = 2;
            }
        } else {
            errFlag = 1;
        }

        // Preprocessing: data quantity
        if (errFlag == 0) {
            switch (dataAmt) {
                case "10gb" -> dataAmtQty = Math.pow(2, 30) * 8.0 * 10.0;
                case "20gb" -> dataAmtQty = Math.pow(2, 50) * 8.0 * 20.0;
                case "30gb" -> dataAmtQty = Math.pow(2, 70) * 8.0 * 30.0;
                default -> errFlag = 3;
            }
        }

        switch (errFlag) {
            case 1 ->
                    System.out.println("Error: Invalid value entered for the 'Mode' variable. Kindly retry with a valid input.");
            case 2 ->
                    System.out.println("Error: Invalid value entered for the 'Weekday' variable. Kindly retry with a valid input.");
            case 3 ->
                    System.out.println("Error: Invalid value entered for the 'Data Quantity' variable. Kindly retry with a valid input.");
            default -> {
                // Compute Latency
                latVal = (dataAmtQty / bndWdthQty) * 1000;
                System.out.printf("Latency incurred in transmitting %s of data, over Project-S microwave network link, is: %fms%n", dataAmt.toUpperCase(), latVal);
            }
        }

        // Display complimentary-close message
        System.out.println("\nOnce again, thanks for your contribution to Project-S.");

        // Close the Scanner object
        inputScanner.close();
    }
}
