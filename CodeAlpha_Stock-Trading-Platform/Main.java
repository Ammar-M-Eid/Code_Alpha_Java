
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MarketData market = new MarketData();
        Portfolio portfolio = new Portfolio();
        Transaction transactions = new Transaction();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            market.readFromFile();

            while (running) {
                System.out.println("Welcome to the Stock Trading Platform");
                System.out.println("1. View Market Data");
                System.out.println("2. View Portfolio");
                System.out.println("3. View Transactions");
                System.out.println("4. Buy Stock");
                System.out.println("5. Sell Stock");
                System.out.println("6. Exit");
                System.out.print("Please select an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 ->
                        System.out.println(market.printMarket());
                    case 2 ->
                        System.out.println(portfolio.printPortfolio());
                    case 3 ->
                        System.out.println(transactions.printTransactions());
                    case 4 -> {
                        System.out.print("Enter stock symbol: ");
                        String buySymbol = scanner.nextLine();
                        System.out.print("Enter quantity: ");
                        int buyQuantity = scanner.nextInt();
                        double buyPrice = market.getPrice(buySymbol); 
                        portfolio.addHolding(buySymbol, buyQuantity, buyPrice);
                        transactions.addTransaction("Buy", buySymbol, buyQuantity, buyPrice);
                    }
                    case 5 -> {
                        System.out.print("Enter stock symbol: ");
                        String sellSymbol = scanner.nextLine();
                        System.out.print("Enter quantity: ");
                        int sellQuantity = scanner.nextInt();
                        double sellPrice = market.getPrice(sellSymbol); 
                        portfolio.removeHolding(sellSymbol, sellQuantity);
                        transactions.addTransaction("Sell", sellSymbol, sellQuantity, sellPrice);
                    }
                    case 6 ->
                        running = false;
                    default ->
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }
}
