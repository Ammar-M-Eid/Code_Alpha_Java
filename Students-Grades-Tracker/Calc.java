
import java.util.ArrayList;
public class Calc {
public static double Average(){
    double average=0;
    ArrayList<Double> Grades = Read.getGrades();
    for(double grade:Grades) average = +grade;
    return (average/Grades.size());
}
public static double Highest(){
    double highest=0;
    ArrayList<Double> Grades = Read.getGrades();
    for(double grade:Grades) {
        if (grade > highest) highest= grade;
    }
    return highest;
}

public static double Lowest(){
        double lowest= Highest();
        ArrayList<Double> Grades = Read.getGrades();
        for(double grade:Grades) {
            if (grade < lowest) lowest= grade;
        }
        return lowest;
}

}
