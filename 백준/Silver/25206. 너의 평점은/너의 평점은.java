import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totalScore = 0, totalCredit = 0;
        double credit, gradePoint = 0.0;
        String grade;
        
        for(int i = 0; i < 20; i++) {
            String[] myclass = br.readLine().split(" "); 
            
            credit = Double.parseDouble(myclass[1]);
            grade = myclass[2];
            
            if (grade.equals("A+")) gradePoint = 4.5;
            if (grade.equals("A0")) gradePoint = 4.0;
            if (grade.equals("B+")) gradePoint = 3.5;
            if (grade.equals("B0")) gradePoint = 3.0;
            if (grade.equals("C+")) gradePoint = 2.5;
            if (grade.equals("C0")) gradePoint = 2.0;
            if (grade.equals("D+")) gradePoint = 1.5;
            if (grade.equals("D0")) gradePoint = 1.0;
            if (grade.equals("F")) gradePoint = 0.0;
            if (grade.equals("P")) credit = 0.0;
            
            
            
            totalScore += (credit * gradePoint);
            totalCredit += credit;
        }
        
        System.out.print(totalScore / totalCredit);
        
    }
}