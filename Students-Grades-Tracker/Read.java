
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Read {

    private static  ArrayList<Double> Grades = new ArrayList<>();
    public static void readFromUser(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the grade of student " + (i+1));
            double grade = sc.nextDouble();
            Grades.add(grade);
        }


    }


    public static void readFromFile(){
        System.out.println("Enter the file path");

        Scanner sc =new Scanner(System.in);
        String path= sc.nextLine();
        try {
            File myObj = new File(path);
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    Double grade = myReader.nextDouble();
                    Grades.add(grade);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file Name");
        }

    }


    public static ArrayList<Double> getGrades() {
        return Grades;
    }
}
