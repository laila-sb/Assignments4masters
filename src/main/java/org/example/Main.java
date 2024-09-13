package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  //allows capture what user types

        System.out.println("Hello, Welcome to our Gelateria!");
        System.out.println("*******************************");


        System.out.println("Please enter your name:");

        String name = scanner.nextLine();  // get the user's input stores in "name"
        System.out.println("Hello, " + name + "! Let's create your gelato order.");

        System.out.println("Please select from the following flavor options:");
        System.out.println("1. Pistachio (€2.00 per scoop)");
        System.out.println("2. Dark Chocolate (€2.50 per scoop)");
        System.out.println("3. Mango (€1.75 per scoop)");
        System.out.println("4. Matcha (€3.75 per scoop) -WIP");
        System.out.println("5. Lemon (€3.50 per scoop) -WIP");
//                System.out.println("6. Generate Bill and Exit");
//
        int choice = scanner.nextInt();
        scanner.nextLine();

        Gelato gelato = null; //declaring a variable, type Gelato, initialize it


        switch (choice) {
            case 1:
                gelato = new Gelato(GelatoFlavors.PISTACHIO, 2.00);
                break;
            case 2:
                gelato = new Gelato(GelatoFlavors.DARKCHOCOLATE, 2.50);
                break;
            case 3:
                gelato = new Gelato(GelatoFlavors.MANGO, 1.75);
                break;
            case 4:
            case 5:
                System.out.println("Sorry! This flavor are not yet available");
                break;
            default:
                System.out.println("Invalid choice. Please start again and choose a valid number.");
                return;
        }
        if (gelato != null) {
            //chosen flavor // get method
            System.out.println("You chose " + gelato.getFlavor());
            System.out.println("That will be €" + gelato.getPricePerScoop() + " per scoop");
            //number of user scoops
            System.out.println("How many scoops of that would you like?");
            int scoops = scanner.nextInt();

            //calc total price
            double totalPrice = gelato.calculatePrice(scoops);

            //order summary
            System.out.println("Alright " + name + ", your final order is " + scoops + " scoops of " + gelato.getFlavor());
            // gelato.displayInfo();
            System.out.println("Your total will be €" + totalPrice);
        }
    }

}
