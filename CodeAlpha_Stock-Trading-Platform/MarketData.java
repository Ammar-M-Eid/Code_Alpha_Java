import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MarketData {
    ArrayList<String[]> Market =new ArrayList<>();
    public void readFromFile(){
        /*System.out.println("Enter the file path");
        Scanner sc =new Scanner(System.in);*/
        String path= "C:\\Users\\AMMAR MA. EID\\Documents\\MyGitHub\\CodeAlpha_Stock-Trading-Platform\\src\\market_data";
        try {
            File myObj = new File(path);
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    String line= myReader.nextLine();
                    String[] stock;
                    stock= line.split(",");
                    Market.add(stock);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file Name");
        }

    }
    public String printMarket() {
        readFromFile();
        StringBuilder string = new StringBuilder();
        for (String[] s:Market) {
            string.append(Arrays.toString(s)).append("\n");
        }
        return string.toString();
    }
}
