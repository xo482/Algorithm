import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        int cnt=0;
        
        while(N != 1){
            cnt++;

            if (Math.abs(p1-p2) == 1){
                if (p1%2==1 && p1 < p2) break;
                if (p2%2==1 && p2 < p1) break;
            }
            
            p1 = p1/2+p1%2;
            p2 = p2/2+p2%2;
            N = N/2 + N%2;
        }
        
        System.out.print(cnt);
	}
}