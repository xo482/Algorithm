import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        int A, B;
        List<Integer> results = new ArrayList<>();
        
        while(sc.hasNext()){
            A = sc.nextInt();
            B = sc.nextInt();
            results.add(A+B);
        }
        
        for(int result : results){
            System.out.println(result);
        }
    }
}