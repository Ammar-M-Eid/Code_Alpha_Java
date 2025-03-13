
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MarketData market = new MarketData();
        Portfolio portfolio = new Portfolio();
        Transaction transactions = new Transaction();

        market.readFromFile();
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            boolean mainRunning = true;
            while (mainRunning) {
                System.out.println("Choose interface:\n1 for UI\n2 for Terminal\n9 to exit");
                choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println("User selected: " + choice); // Debug statement
                switch (choice) {
                    case 1 -> {
                        System.out.println("Starting UI..."); // Debug statement
                        StockUI ui = new StockUI();
                        ui.startUI(market, portfolio, transactions);
                    }
                    case 2 -> {
                        System.out.println("Starting Terminal Interface..."); // Debug statement
                        boolean running = true;
                        while (running) {
                            System.out.println("1. View Market Data");
                            System.out.println("2. View Portfolio");
                            System.out.println("3. View Transactions");
                            System.out.println("4. Exit");
                            int choice2 = scanner.nextInt();
                            System.out.println("User selected in Terminal: " + choice2); // Debug statement
                            switch (choice2) {
                                case 1 ->
                                    System.out.println(market.printMarket());
                                case 2 ->
                                    System.out.println(portfolio.printPortfolio());
                                case 3 ->
                                    System.out.println(transactions.printTransactions());
                                case 4 ->
                                    running = false;
                                default ->
                                    System.out.println("Invalid choice. Try again.");
                            }
                        }
                    }
                    case 9 -> {
                        System.out.println("Exiting.");
                        mainRunning = false;
                    }
                    default ->
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
        System.out.println("Scanner closed. Program terminated."); // Debug statement
    }
}
