import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("To Enter the grades manually Enter 1 \nTo use existing file enter 2\nTo End Program Enter 9");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice){
            case 1:
                Read.readFromUser();
                break;
            case 2:
                Read.readFromFile();
                break;
            case 9:
                break;
        }
        while (choice!=9){
            System.out.println("Choose:\n1: Average.\n2: Highest\n3: Lowest\n9: Exit");
            choice = sc.nextInt();
            if ( choice==1 ) System.out.println(Calc.Average());
            else if ( choice==2 )System.out.println(Calc.Highest());
            else if ( choice==3 )System.out.println(Calc.Lowest());

        }
        System.out.println("End Program");
    }
}
