import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 분해합
        int M = 0; // 생성자
        int x=0, val =0;;        
        for(int i=1; i < N; i++) {
            x =i;
            
            for(int j = 1; j < N; j *= 10) {
                val = (i % (10*j) - i % j) / j;
                if(val < 1) val = 0;
                x += val;
            }
            
            if(x == N) {
                M = i;
                break;
            }
        }
        
        System.out.print(M);
	}
}