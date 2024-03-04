import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int x = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<cnt; i++){
            int N = Integer.parseInt(st.nextToken()); 
            for(int j=2;j<N;j++){
                if(N % j == 0) {
                    x++;
                    break;
                }
            }
            
            if(N == 1) x++;
        }
        
        System.out.print(cnt - x);
	}
}






