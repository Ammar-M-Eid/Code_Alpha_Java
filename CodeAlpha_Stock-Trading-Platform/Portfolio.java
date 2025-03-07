
import java.util.ArrayList;

public class Portfolio {

    private ArrayList<String[]> holdings = new ArrayList<>();

    public void addHolding(String symbol, int quantity, double price) {
        holdings.add(new String[]{symbol, String.valueOf(quantity), String.valueOf(price)});
    }

    public boolean hasHolding(String symbol) {
        for (String[] holding : holdings) {
            if (holding[0].equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    public void removeHolding(String symbol, int quantity) {
        for (int i = 0; i < holdings.size(); i++) {
            String[] holding = holdings.get(i);
            if (holding[0].equals(symbol)) {
                int currentQuantity = Integer.parseInt(holding[1]);
                if (currentQuantity >= quantity) {
                    currentQuantity -= quantity;
                    if (currentQuantity == 0) {
                        holdings.remove(i);
                    } else {
                        holding[1] = String.valueOf(currentQuantity);
                    }
                } else {
                    System.out.println("Not enough quantity to sell.");
                }
                break;
            }
        }
    }

    public String printPortfolio() {
        StringBuilder portfolioData = new StringBuilder("Portfolio Data:\n");
        for (String[] holding : holdings) {
            portfolioData.append("Symbol: ").append(holding[0])
                    .append(", Quantity: ").append(holding[1])
                    .append(", Price: ").append(holding[2])
                    .append("\n");
        }
        return portfolioData.toString();
    }
}
