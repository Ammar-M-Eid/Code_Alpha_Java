import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
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
        }

        do{
            System.out.println("Choose:\n1: Average.\n2: Highest\n3: Lowest\n4: Exit");
            choice = sc.nextInt();
            if ( choice==1 ) System.out.println(Calc.Average());
            else if ( choice==2 )System.out.println(Calc.Highest());
            else if ( choice==3 )System.out.println(Calc.Lowest());

        }while (choice!=4);





    }

}