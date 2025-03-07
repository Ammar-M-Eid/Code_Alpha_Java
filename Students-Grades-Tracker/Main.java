
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("To Enter the grades manually Enter 1 \nTo use existing file enter 2\nTo End Program Enter 9");
        try (Scanner sc = new Scanner(System.in)) {
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 ->
                    Read.readFromUser();
                case 2 ->
                    Read.readFromFile();
                case 9 -> {
                }
            }
            while (choice != 9) {
                System.out.println("Choose:\n1: Average.\n2: Highest\n3: Lowest\n9: Exit");
                choice = sc.nextInt();
                switch (choice) {
                    case 1 ->
                        System.out.println(Calc.Average());
                    case 2 ->
                        System.out.println(Calc.Highest());
                    case 3 ->
                        System.out.println(Calc.Lowest());
                }

            }
        }
        System.out.println("End Program");
    }
}
