/**
 * @programDescription Static Latency-Computer Program
 * A basic program for computing the latency (in milliseconds) incurred during the transfer of a given
 * quantity of data, from a source (IP address) node to a destination (IP address) node, over a predefined
 * (via bandwidth) communication channel/link within the Project-S Metropolitan Area Network (MAN).
 * a valid IPv4 address possesses the following syntax based on decimal (base-10) number system: {0 to 255}.{0 to 255}.{0 to 255}.{0 to 255}
 */

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        // Prints a welcome message
        System.out.println("Welcome to the Static Latency-Computer Program:");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");

        // Variable declarations
        String bndWdth, bndWdthUnit, dataAmt, dataAmtUnit;
        double bndWdthNum , bndWdthQty = 0.0, dataAmtNum , dataAmtQty = 0.0, latVal;
        short srcIP1 = -1, srcIP2 = -1, srcIP3 = -1, srcIP4 = -1, destIP1 = -1, destIP2 = -1, destIP3 = -1, destIP4 = -1;
        int errFlag = 0;
        Scanner inputScanner = new Scanner(System.in); // Open a Scanner object

        // Prompt the user for bandwidth input
        System.out.print("\nPlease enter the bandwidth, in {n}{x}bps format, for the network link: ");
        bndWdth = inputScanner.nextLine();

        // Preprocess bandwidth data
        bndWdthNum = Double.parseDouble(bndWdth.substring(0, bndWdth.length() - 4));
        bndWdthUnit = bndWdth.substring(bndWdth.length() - 4);

        switch (bndWdthUnit) {
            case "Kbps" -> bndWdthQty = Math.pow(2, 10) * bndWdthNum;
            case "Mbps" -> bndWdthQty = Math.pow(2, 20) * bndWdthNum;
            case "Gbps" -> bndWdthQty = Math.pow(2, 30) * bndWdthNum;
            case "Tbps" -> bndWdthQty = Math.pow(2, 40) * bndWdthNum;
            case "Pbps" -> bndWdthQty = Math.pow(2, 50) * bndWdthNum;
            case "Ebps" -> bndWdthQty = Math.pow(2, 60) * bndWdthNum;
            case "Zbps" -> bndWdthQty = Math.pow(2, 70) * bndWdthNum;
            case "Ybps" -> bndWdthQty = Math.pow(2, 80) * bndWdthNum;
            default -> errFlag = 1;
        }

        // Prompt the user for source IP address
        if (errFlag == 0) {
            System.out.print("Please enter the source IP address: ");
            if (inputScanner.hasNextShort()) {
                srcIP1 = inputScanner.nextShort();
            } else {
                errFlag = 2;
            }
            if (inputScanner.hasNextShort()) {
                srcIP2 = inputScanner.nextShort();
            } else {
                errFlag = 2;
            }
            if (inputScanner.hasNextShort()) {
                srcIP3 = inputScanner.nextShort();
            } else {
                errFlag = 2;
            }
            if (inputScanner.hasNextShort()) {
                srcIP4 = inputScanner.nextShort();
            } else {
                errFlag = 2;
            }
            if ((srcIP1 < 0 || srcIP1 > 255) || (srcIP2 < 0 || srcIP2 > 255) || (srcIP3 < 0 || srcIP3 > 255) || (srcIP4 < 0 || srcIP4 > 255)) {
                errFlag = 2;
            }
        }

        // Prompt the user for destination IP address
        if (errFlag == 0) {
            System.out.print("Please enter the destination IP address: ");
            if (inputScanner.hasNextShort()) {
                destIP1 = inputScanner.nextShort();
            } else {
                errFlag = 3;
            }
            if (inputScanner.hasNextShort()) {
                destIP2 = inputScanner.nextShort();
            } else {
                errFlag = 3;
            }
            if (inputScanner.hasNextShort()) {
                destIP3 = inputScanner.nextShort();
            } else {
                errFlag = 3;
            }
            if (inputScanner.hasNextShort()) {
                destIP4 = inputScanner.nextShort();
            } else {
                errFlag = 3;
            }
            if ((destIP1 < 0 || destIP1 > 255) || (destIP2 < 0 || destIP2 > 255) || (destIP3 < 0 || destIP3 > 255) || (destIP4 < 0 || destIP4 > 255)) {
                errFlag = 3;
            }
        }

        // Prompt the user for data-amount input
        if (errFlag == 0) {
            System.out.print("Please enter data amount, in {n}{y}B format, for transmission over the network link: ");
            inputScanner.nextLine();
            dataAmt = inputScanner.nextLine();

            // Preprocess bandwidth data
            dataAmtNum = Double.parseDouble(dataAmt.substring(0, dataAmt.length() - 2));
            dataAmtUnit = dataAmt.substring(dataAmt.length() - 2);

            switch (dataAmtUnit) {
                case "KB" -> dataAmtQty = Math.pow(2, 10) * 8.0 * dataAmtNum;
                case "MB" -> dataAmtQty = Math.pow(2, 20) * 8.0 * dataAmtNum;
                case "GB" -> dataAmtQty = Math.pow(2, 30) * 8.0 * dataAmtNum;
                case "TB" -> dataAmtQty = Math.pow(2, 40) * 8.0 * dataAmtNum;
                case "PB" -> dataAmtQty = Math.pow(2, 50) * 8.0 * dataAmtNum;
                case "EB" -> dataAmtQty = Math.pow(2, 60) * 8.0 * dataAmtNum;
                case "ZB" -> dataAmtQty = Math.pow(2, 70) * 8.0 * dataAmtNum;
                case "YB" -> dataAmtQty = Math.pow(2, 80) * 8.0 * dataAmtNum;
                default -> errFlag = 4;
            }
        }

        // Compute Latency
        latVal = (dataAmtQty / bndWdthQty) * 1000;

        if (errFlag == 1) {
            System.out.println("Invalid input for bandwidth; please re-run and enter the bandwidth in {n}{x}bps format.");
        } else if (errFlag == 2) {
            System.out.println("Error: Your entry for source IP address is incorrect. Kindly retry with valid inputs.");
        } else if (errFlag == 3) {
            System.out.println("Error: Your entry for destination IP address is incorrect. Kindly retry with valid inputs.");
        } else if (errFlag == 4) {
            System.out.println("Invalid input for the amount of data; please retry with the data amount in {n}{y}B format.");
        } else {
            String srcIP = srcIP1 + "." + srcIP2 + "." + srcIP3 + "." + srcIP4;
            String destIP = destIP1 + "." + destIP2 + "." + destIP3 + "." + destIP4;
            System.out.println("Latency (" + srcIP + " --> " + destIP + ") = " + latVal + " ms");
        }

        // Display complimentary-close message
        System.out.println("\nThank you for your contribution to Project-S.");

        // Close the Scanner object
        inputScanner.close();
    }

}
