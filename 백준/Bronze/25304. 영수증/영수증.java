import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int totalPrice = sc.nextInt();
        int cnt = sc.nextInt();
        int list[] = new int[cnt];
        int product, number;
        
        for(int i=0;i<cnt;i++){
            product = sc.nextInt();
            number = sc.nextInt();
            totalPrice -= product*number;
        }
        
        if(totalPrice == 0)
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}