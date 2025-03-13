
import java.awt.*;
import javax.swing.*;

public class StockUI {
   public void startUI( MarketData market, Portfolio portfolio, Transaction transactions) {
    
    JFrame frame = new JFrame("Stock Trading Platform");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    frame.setLayout(new BorderLayout());

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(6, 1));

    JLabel welcomeLabel = new JLabel("Welcome to Code Alpha Stock Trading Platform", SwingConstants.CENTER);
    frame.add(welcomeLabel, BorderLayout.NORTH);

    JTextArea marketDataArea = new JTextArea(market.printMarket());
    marketDataArea.setEditable(false);
    JScrollPane marketScrollPane = new JScrollPane(marketDataArea);
    frame.add(marketScrollPane, BorderLayout.CENTER);

    JButton viewPortfolioButton = new JButton("View Portfolio");
    JButton viewTransactionsButton = new JButton("View Transactions");
    JButton buyStockButton = new JButton("Buy Stock");
    JButton sellStockButton = new JButton("Sell Stock");
    JButton refreshMarketButton = new JButton("Refresh Market Data");
    JButton exitButton = new JButton("Exit");

    viewPortfolioButton.setBackground(new Color(0x3E5879)); 
    viewPortfolioButton.setForeground(new Color(0xF5EFE7)); 
    viewTransactionsButton.setBackground(new Color(0x3E5879));
    viewTransactionsButton.setForeground(new Color(0xF5EFE7));
    buyStockButton.setBackground(new Color(0x3E5879));
    buyStockButton.setForeground(new Color(0xF5EFE7));
    sellStockButton.setBackground(new Color(0x3E5879));
    sellStockButton.setForeground(new Color(0xF5EFE7));
    refreshMarketButton.setBackground(new Color(0x3E5879));
    refreshMarketButton.setForeground(new Color(0xF5EFE7));
    exitButton.setBackground(new Color(0x3E5879));
    exitButton.setForeground(new Color(0xF5EFE7));

    buttonPanel.add(viewPortfolioButton);
    buttonPanel.add(viewTransactionsButton);
    buttonPanel.add(buyStockButton);
    buttonPanel.add(sellStockButton);
    buttonPanel.add(refreshMarketButton);
    buttonPanel.add(exitButton);

    frame.add(buttonPanel, BorderLayout.EAST);

    viewPortfolioButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, portfolio.printPortfolio()));
    viewTransactionsButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, transactions.printTransactions()));

    buyStockButton.addActionListener(e -> {
        String buySymbol = JOptionPane.showInputDialog("Enter stock symbol:");
        String buyQuantityStr = JOptionPane.showInputDialog("Enter quantity:");
        int buyQuantity = Integer.parseInt(buyQuantityStr);
        double buyPrice = market.getPrice(buySymbol);
        if (buyPrice == 0) {
            JOptionPane.showMessageDialog(frame, "Stock does not exist in the market.");
            return;
        }
        portfolio.addHolding(buySymbol, buyQuantity, buyPrice);
        transactions.addTransaction("Buy", buySymbol, buyQuantity, buyPrice);
    });

    sellStockButton.addActionListener(e -> {
        String sellSymbol = JOptionPane.showInputDialog("Enter stock symbol:");
        String sellQuantityStr = JOptionPane.showInputDialog("Enter quantity:");
        int sellQuantity = Integer.parseInt(sellQuantityStr);
        double sellPrice = market.getPrice(sellSymbol);
        if (!portfolio.hasHolding(sellSymbol)) {
            JOptionPane.showMessageDialog(frame, "Stock is not in the portfolio.");
            return;
        }
        portfolio.removeHolding(sellSymbol, sellQuantity);
        transactions.addTransaction("Sell", sellSymbol, sellQuantity, sellPrice);
    });

    refreshMarketButton.addActionListener(e -> {
        market.readFromFile();
        marketDataArea.setText(""); 
        marketDataArea.setText(market.printMarket()); 
    });

    exitButton.addActionListener(e -> System.exit(0));

    frame.setVisible(true);

   }
}
