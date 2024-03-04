import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        
        if(score > 89)
            System.out.print("A");
        else if(score > 79)
            System.out.print("B");
        else if(score > 69)
            System.out.print("C");
        else if(score > 59)
            System.out.print("D");
        else
            System.out.print("F");
    }
}