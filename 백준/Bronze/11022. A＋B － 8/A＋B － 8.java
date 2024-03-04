import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int list[][] = new int[T][2];
        int A, B, i;
        
        for(i=0;i<T;i++){
            list[i][0] = sc.nextInt();
            list[i][1] = sc.nextInt();
        }
        for(i=0;i<T;i++){
            System.out.println("Case #" + (i+1) + ": " + list[i][0] + " + " + list[i][1] + " = " + (list[i][0] + list[i][1]));
        }
    }
}