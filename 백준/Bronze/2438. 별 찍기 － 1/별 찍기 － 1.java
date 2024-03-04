import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int i, j;
        for(j = 1; j < T+1; j++){
            for(i = 0; i < j; i++){
                System.out.print("*");
            }
            i=0;
            System.out.print("\n");
        }
    }
}