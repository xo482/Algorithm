import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        
        if(minute < 45){
            minute += 15;
            
            if(hour == 0)
                hour = 23;
            else
                hour--;
        }
        else
            minute -= 45;
        
        System.out.print(hour + " " + minute);
    }
}