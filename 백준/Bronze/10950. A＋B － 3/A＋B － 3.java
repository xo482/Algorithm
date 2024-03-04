import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int x, y, i;
        int list[] = new int[cnt];
        
        
        for(i=0;i<cnt;i++){
            x = sc.nextInt();
            y = sc.nextInt();
            list[i] = x+y;
        }
        
        for(i=0;i<cnt;i++){
            System.out.println(list[i]);
        }
    }
}