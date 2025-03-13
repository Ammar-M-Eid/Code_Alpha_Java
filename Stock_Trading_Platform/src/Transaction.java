
import java.util.ArrayList;

public class Transaction {

    private final ArrayList<String[]> transactions = new ArrayList<>();

    public void addTransaction(String type, String symbol, int quantity, double price) {
        transactions.add(new String[]{type, symbol, String.valueOf(quantity), String.valueOf(price)});
    }

    public String printTransactions() {
        StringBuilder transactionData = new StringBuilder("Transaction Data:\n");
        for (String[] transaction : transactions) {
            transactionData.append("Type: ").append(transaction[0])
                    .append(", Symbol: ").append(transaction[1])
                    .append(", Quantity: ").append(transaction[2])
                    .append(", Price: ").append(transaction[3])
                    .append("\n");
        }
        return transactionData.toString();
    }
}
