package WebHistory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WebBrowserHistory browser = new WebBrowserHistory();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Web Browser History ===");
            System.out.println("Current Page: " + (browser.getCurrentPage() != null ? browser.getCurrentPage() : "None"));
            System.out.println("1. Visit new page");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter URL: ");
                    String url = scanner.nextLine();
                    try {
                        browser.visitPage(url);
                        System.out.println("Visited: " + browser.getCurrentPage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    String backPage = browser.back();
                    if (backPage != null) {
                        System.out.println("Back to: " + backPage);
                    } else {
                        System.out.println("Cannot go back: No previous page.");
                    }
                    break;

                case 3:
                    String forwardPage = browser.forward();
                    if (forwardPage != null) {
                        System.out.println("Forward to: " + forwardPage);
                    } else {
                        System.out.println("Cannot go forward: No next page.");
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1-4.");
            }
        }
    }
}