import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int list[] = new int[T];
        int A, B, i;
        
        for(i=0;i<T;i++){
            A = sc.nextInt();
            B = sc.nextInt();
            list[i] = A + B;
        }
        for(i=0;i<T;i++){
            System.out.println("Case #" + (i+1) + ": " + list[i]);
        }
    }
}