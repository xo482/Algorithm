import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0;i < 2*N-1; i++){
            if(i < N){
                System.out.print(" ".repeat((N-1) - i));
                System.out.println("*".repeat(i*2 + 1));    
            } else{
                System.out.print(" ".repeat(i - (N-1)));
                System.out.println("*".repeat((2*N-1) - (2*i - (2*N-2))));
            }
        }
    }
}