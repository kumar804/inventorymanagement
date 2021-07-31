package Util;

import java.util.Scanner;

public class UserInputOutput {
    private static final Scanner scanner = new Scanner(System.in);


    public static int getUserChoice() {
        System.out.println("Enter option");
        System.out.println("Enter 1 to Add");
        System.out.println("Enter 2 to Edit");
        System.out.println("Enter 3 to Delete");
        System.out.println("Enter 4 to Display");
        System.out.println("Enter 5 to Calculate Total Value");
        System.out.println("Enter 6 to Calculate Total Weight");
        System.out.println("Enter 7 to Calculate Total Price");
        System.out.println("Enter 8 to Quit" + "\n");

        return scanner.nextInt();
    }
}
