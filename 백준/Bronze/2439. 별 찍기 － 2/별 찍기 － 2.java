import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int i;
        
        for(i=1;i<=T;i++){
            System.out.println(" ".repeat(T-i) + "*".repeat(i));
        }
    }
}