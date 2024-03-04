import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            int number = Integer.parseInt(br.readLine());
            int sum = 1;
            StringBuilder sb = new StringBuilder(number + " = 1");
            
            if(number == -1) break;
            
            for(int i=2; i<=number/2; i++){
                if(number % i == 0) {
                    sum += i;
                    sb.append(" + " + i);
                }
            }
            
            if(sum == number) {
                String str = sb.toString();
                System.out.println(str);
            } else {
                System.out.println(number + " is NOT perfect.");
            }
           
        }
        
	}
}