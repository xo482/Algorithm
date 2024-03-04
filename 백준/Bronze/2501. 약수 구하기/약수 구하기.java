import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
     
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int x=0;
        boolean y = true;
        
        for(int i=1; i<=N; i++){
            if(N % i == 0){
                if (++x == K){
                    System.out.println(i);
                    y = false;
                }
            }
        }
        
        if(y) {
            System.out.println(0);
        }
	}
}