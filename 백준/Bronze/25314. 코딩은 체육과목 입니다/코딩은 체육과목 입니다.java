import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        size /= 4;
        
        for(int i=0; i<size;i++){
            System.out.print("long ");
        }
        System.out.print("int");
    }
}