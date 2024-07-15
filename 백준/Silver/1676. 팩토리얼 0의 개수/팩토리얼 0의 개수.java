import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int Zero_num = (int) N/5 + (int) N/25 + (int) N/125;

        System.out.println(Zero_num);
    }
}