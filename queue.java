/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject17;
import java.util.*;
/**
 *
 * @author DELL
 */
public class Mavenproject17 {

    static class Customer {
        String name;
        int number;

        Customer(String name, int number) {
            this.name = name;
            this.number = number;
        }
    }

    public static void main(String[] args) {
        Queue<Customer> queue = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        int counter = 1;
        boolean running = true;

        while (running) {
            System.out.println("\nBank Menu:");
            System.out.println("1. Add customer to queue");
            System.out.println("2. Serve next customer");
            System.out.println("3. View queue");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter name here: ");
                    String name = input.nextLine();
                    queue.add(new Customer(name, counter++));
                    System.out.println("Customer added.");
                    break;

                case "2":
                    if (queue.isEmpty()) {
                        System.out.println("No one to serve.");
                    } else {
                        Customer served = queue.poll();
                        System.out.println("Serving " + served.name + " (No. " + served.number + ")");
                    }
                    break;

                case "3":
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("People in queue:");
                        for (Customer c : queue) {
                            System.out.println("- " + c.name + " (No. " + c.number + ")");
                        }
                    }
                    break;

                case "4":
                    running = false;
                    System.out.println("The Session ended.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}