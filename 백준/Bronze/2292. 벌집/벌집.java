import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int x=1, i=1;
        int range=1;
        
        while(N > range){
            range = 6*x + 1;
            i++;
            x += i;
        }
        
        System.out.println(i);
	}
}