
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MarketData {

    ArrayList<String[]> Market = new ArrayList<>(); 

    public void clearMarket() {
        Market.clear();
    }


    public void readFromFile() {
        String path = "C:\\Users\\AMMAR MA. EID\\Documents\\MyGitHub\\Code_Alpha_Java\\CodeAlpha_Stock-Trading-Platform\\market_data";
        clearMarket(); 
        try {
            File myObj = new File(path); 

            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    String line = myReader.nextLine();
                    String[] stock;
                    stock = line.split(",");
                    Market.add(stock);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file Name");
        }
    }

    public String printMarket() {
        StringBuilder marketData = new StringBuilder("Market Data:\n");
        for (String[] stock : Market) {
            marketData.append("Symbol: ").append(stock[0])
                    .append(", Price: ").append(stock[1])
                    .append(", Volume: ").append(stock[2])
                    .append("\n");
        }
        return marketData.toString();
    }

    public double getPrice(String symbol) {
        for (String[] stock : Market) {
            if (stock[0].equals(symbol)) {
                return Double.parseDouble(stock[1]);
            }
        }
        return 0;
    }
}
