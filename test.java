/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject16;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class Mavenproject16 {

    static class TaskNode {
        String title;
        TaskNode next;

        TaskNode(String title) {
            this.title = title;
        }
    }

    static class TaskList {
        TaskNode head;

        void add(String title) {
            TaskNode newTask = new TaskNode(title);
            if (head == null) {
                head = newTask;
            } else {
                TaskNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newTask;
            }
            System.out.println("Added: " + title);
        }

        void delete(String title) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
            if (head.title.equals(title)) {
                head = head.next;
                System.out.println("Deleted: " + title);
                return;
            }
            TaskNode current = head;
            while (current.next != null && !current.next.title.equals(title)) {
                current = current.next;
            }
            if (current.next == null) {
                System.out.println("Task is not found.");
            } else {
                current.next = current.next.next;
                System.out.println("Deleted: " + title);
            }
        }

        void show() {
            if (head == null) {
                System.out.println("No tasks.");
                return;
            }
            System.out.println("Tasks:");
            TaskNode current = head;
            while (current != null) {
                System.out.println("- " + current.title);
                current = current.next;
            }
        }

        boolean find(String title) {
            TaskNode current = head;
            while (current != null) {
                if (current.title.equals(title)) return true;
                current = current.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskList list = new TaskList();
        boolean running = true;

        while (running) {
            System.out.println("\nMenu: 1-Add task | 2-Delete task | 3-Show/View all task | 4-Search task | 5-Exit");
            System.out.print("Enter Choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Task Title: ");
                    list.add(sc.nextLine());
                    break;
                case "2":
                    System.out.print("Task to delete: ");
                    list.delete(sc.nextLine());
                    break;
                case "3":
                    list.show();
                    break;
                case "4":
                    System.out.print("Search Task Title: ");
                    System.out.println(list.find(sc.nextLine()) ? "Task Found!" : "Not found.");
                    break;
                case "5":
                    running = false;
                    System.out.println("THANK YOU,Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}